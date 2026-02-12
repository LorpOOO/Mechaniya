package net.lorp.mechaniya.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class ModFallingBlocks extends FallingBlock {

    public ModFallingBlocks(Properties properties) {
        super(properties);
    }
    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return null;
    }
}
