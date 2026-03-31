package net.lorp.mechaniya.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class ParaffinWaxItem extends Item {
    public ParaffinWaxItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        return HoneycombItem.getWaxed(state).map(waxedState -> {
            level.setBlockAndUpdate(pos, waxedState);
            level.levelEvent(context.getPlayer(), 3003, pos, 0); // Звук та іскри
            context.getItemInHand().shrink(1); // Забираємо 1 парафін
            return InteractionResult.sidedSuccess(level.isClientSide);
        }).orElse(super.useOn(context));
    }
}