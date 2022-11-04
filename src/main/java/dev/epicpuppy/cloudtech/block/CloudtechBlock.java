package dev.epicpuppy.cloudtech.block;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CloudtechBlock extends Block implements ICloudBlock {

    private int blockColor;
    public CloudtechBlock(CloudTier tier, Properties pProperties) {
        super(pProperties);
        this.blockColor = tier.tColor;
    }

    @Override
    public int getColor(BlockState pState, @Nullable BlockAndTintGetter pLevel, @Nullable BlockPos pPos, int pTintIndex) {
        return (pTintIndex == 0 ? this.blockColor : 16777215);
    }
}
