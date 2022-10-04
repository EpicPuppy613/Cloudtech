package dev.epicpuppy.cloudtech.block;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CloudtechBlockItem extends BlockItem {

    public final CloudTier cTier;

    public CloudtechBlockItem(Block pBlock, CloudTier cTier, Properties pProperties) {
        super(pBlock, pProperties);
        this.cTier = cTier;
    }

    public CloudTier getCloudTier() {
        return this.cTier;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tier.cloudtech." + this.cTier.pName).withStyle(
                    Style.EMPTY.withColor(TextColor.parseColor(this.cTier.pColor))));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.cloudtech.view"));
        }
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack pStack) {
        MutableComponent nameComponent = (new TextComponent("").append(new TranslatableComponent(this.getDescriptionId(pStack)).getString()));
        Style nameStyle = Style.EMPTY.withColor(TextColor.parseColor(this.cTier.pColor));
        nameComponent.setStyle(nameStyle);
        return nameComponent;
    }
}
