package net.lorp.mechaniya.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import org.jetbrains.annotations.Nullable;

public class ModFallingBlocks extends FallingBlock {

    public ModFallingBlocks(Properties properties) {
        super(properties);
    }
    @Override
    protected @Nullable MapCodec<? extends FallingBlock> codec() {
        return null;
    }
}
