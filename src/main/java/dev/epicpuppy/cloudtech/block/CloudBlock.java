package dev.epicpuppy.cloudtech.block;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CloudBlock extends GlassBlock implements ICloudBlock {

    private int blockColor;
    public CloudBlock(CloudTier tier, Properties p_53640_) {
        super(p_53640_);
        this.blockColor = tier.tColor;
    }

    @Override
    public int getColor(BlockState pState, @Nullable BlockAndTintGetter pLevel, @Nullable BlockPos pPos, int pTintIndex) {
        return (pTintIndex == 0 ? this.blockColor : 16777215);
    }
}
