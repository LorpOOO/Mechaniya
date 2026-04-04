package net.lorp.mechaniya.common.item;

import net.lorp.mechaniya.client.models.items.electric_drill.ElectricDrillRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class ElectricDrillItem extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final int ENERGY_CAPACITY = 500000;
    public static final int ENERGY_PER_BLOCK = 100;

    private static final String NBT_MODE_3X3 = "is_3x3_mode";
    private static final String NBT_SPEED = "drill_speed_index";

    public ElectricDrillItem(Properties properties) {
        super(properties);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        if (getEnergy(stack) < ENERGY_PER_BLOCK) return 0.1F;

        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            int index = getSpeedIndex(stack);
            return switch (index) {
                case 3 -> 1500.0F;
                case 2 -> 50.0F;
                case 1 -> 30.0F;
                default -> 10.0F;
            };
        }
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (Screen.hasControlDown() && Screen.hasShiftDown()) {
                int nextSpeed = (getSpeedIndex(stack) + 1) % 4;
                setSpeedIndex(stack, nextSpeed);

                ChatFormatting color = switch (nextSpeed) {
                    case 3 -> ChatFormatting.LIGHT_PURPLE;
                    case 2 -> ChatFormatting.RED;
                    case 1 -> ChatFormatting.YELLOW;
                    default -> ChatFormatting.GREEN;
                };

                String speedKey = switch (nextSpeed) {
                    case 3 -> "tooltip.mechaniya.speed.insane";
                    case 2 -> "tooltip.mechaniya.speed.high";
                    case 1 -> "tooltip.mechaniya.speed.medium";
                    default -> "tooltip.mechaniya.speed.low";
                };

                player.sendSystemMessage(Component.translatable("message.mechaniya.drill_speed",
                        Component.translatable(speedKey)).withStyle(color));

                level.playSound(null, player.getX(), player.getY(), player.getZ(), net.minecraft.sounds.SoundEvents.EXPERIENCE_ORB_PICKUP, player.getSoundSource(), 0.5F, 1.5F);
                return InteractionResultHolder.success(stack);
            }

            if (player.isCrouching()) {
                boolean nextMode = !is3x3Mode(stack);
                set3x3Mode(stack, nextMode);

                player.sendSystemMessage(Component.translatable("message.mechaniya.drill_mode",
                                Component.translatable(nextMode ? "tooltip.mechaniya.mode.3x3" : "tooltip.mechaniya.mode.1x1"))
                        .withStyle(nextMode ? ChatFormatting.GREEN : ChatFormatting.RED));

                level.playSound(null, player.getX(), player.getY(), player.getZ(), net.minecraft.sounds.SoundEvents.EXPERIENCE_ORB_PICKUP, player.getSoundSource(), 0.5F, 1.2F);
                return InteractionResultHolder.success(stack);
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F) {
            consumeEnergy(stack, ENERGY_PER_BLOCK);

            if (is3x3Mode(stack) && entity instanceof Player player) {
                HitResult rayTrace = player.pick(5.0D, 0.0F, false);
                if (rayTrace instanceof BlockHitResult blockHit) {
                    Direction side = blockHit.getDirection();
                    for (BlockPos targetPos : get3x3Area(pos, side)) {
                        if (getEnergy(stack) < ENERGY_PER_BLOCK) break;
                        BlockState targetState = level.getBlockState(targetPos);
                        if (isCorrectToolForDrops(stack, targetState)) {
                            Block.dropResources(targetState, level, targetPos, null, player, stack);
                            level.removeBlock(targetPos, false);
                            level.levelEvent(2001, targetPos, Block.getId(targetState));
                            consumeEnergy(stack, ENERGY_PER_BLOCK);
                        }
                    }
                }
            }
        }
        return true;
    }

    private List<BlockPos> get3x3Area(BlockPos center, Direction side) {
        List<BlockPos> positions = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (side.getAxis() == Direction.Axis.Y) positions.add(center.offset(i, 0, j));
                else if (side.getAxis() == Direction.Axis.X) positions.add(center.offset(0, i, j));
                else positions.add(center.offset(i, j, 0));
            }
        }
        return positions;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag flag) {
        String modeName = is3x3Mode(stack) ? "tooltip.mechaniya.mode.3x3" : "tooltip.mechaniya.mode.1x1";
        tooltip.add(Component.translatable("tooltip.mechaniya.drill_mode", Component.translatable(modeName)).withStyle(ChatFormatting.GOLD));

        int index = getSpeedIndex(stack);
        ChatFormatting speedCol = switch (index) {
            case 3 -> ChatFormatting.LIGHT_PURPLE;
            case 2 -> ChatFormatting.RED;
            case 1 -> ChatFormatting.YELLOW;
            default -> ChatFormatting.GREEN;
        };
        String speedKey = switch (index) {
            case 3 -> "tooltip.mechaniya.speed.insane";
            case 2 -> "tooltip.mechaniya.speed.high";
            case 1 -> "tooltip.mechaniya.speed.medium";
            default -> "tooltip.mechaniya.speed.low";
        };
        tooltip.add(Component.translatable("tooltip.mechaniya.drill_speed", Component.translatable(speedKey)).withStyle(speedCol));

        tooltip.add(Component.translatable("tooltip.mechaniya.energy", getEnergy(stack), ENERGY_CAPACITY).withStyle(ChatFormatting.AQUA));

        tooltip.add(Component.empty());
        tooltip.add(Component.translatable("tooltip.mechaniya.instruction.mode").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        tooltip.add(Component.translatable("tooltip.mechaniya.instruction.speed").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));

        super.appendHoverText(stack, context, tooltip, flag);
    }


    @Override public boolean isBarVisible(ItemStack stack) { return true; }
    @Override public int getBarWidth(ItemStack stack) { return Math.round(13.0f * getEnergy(stack) / ENERGY_CAPACITY); }
    @Override public int getBarColor(ItemStack stack) { return 0x00E1FF; }

    public int getEnergy(ItemStack stack) { return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).getUnsafe().getInt("energy"); }
    public void setEnergy(ItemStack stack, int amount) { stack.update(DataComponents.CUSTOM_DATA, CustomData.EMPTY, cd -> cd.update(tag -> tag.putInt("energy", amount))); }
    private void consumeEnergy(ItemStack stack, int amount) { setEnergy(stack, Math.max(0, getEnergy(stack) - amount)); }

    private boolean is3x3Mode(ItemStack stack) { return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).getUnsafe().getBoolean(NBT_MODE_3X3); }
    private void set3x3Mode(ItemStack stack, boolean mode) { stack.update(DataComponents.CUSTOM_DATA, CustomData.EMPTY, cd -> cd.update(tag -> tag.putBoolean(NBT_MODE_3X3, mode))); }

    private int getSpeedIndex(ItemStack stack) { return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).getUnsafe().getInt(NBT_SPEED); }
    private void setSpeedIndex(ItemStack stack, int index) { stack.update(DataComponents.CUSTOM_DATA, CustomData.EMPTY, cd -> cd.update(tag -> tag.putInt(NBT_SPEED, index))); }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        AnimatableManager.ControllerRegistrar idleAnimation = controllers.add(
                new AnimationController<>(this, "idle_animation", 0, state -> {
                    return state.setAndContinue(RawAnimation.begin().thenLoop("electic_drill.idle_animation"));
                }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private final ElectricDrillRenderer renderer = new ElectricDrillRenderer();

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer(){ return this.renderer; }
        });
    }
}