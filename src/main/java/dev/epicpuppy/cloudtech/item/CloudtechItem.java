package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CloudtechItem extends Item implements ICloudItem {

    public CloudTier cTier;
    private int toolColor;

    public CloudtechItem(CloudTier cTier, Properties pProperties) {
        super(pProperties);
        this.cTier = cTier;
        this.toolColor = cTier.tColor;
    }

    public CloudTier getCloudTier() {
        return this.cTier;
    }

    @Override
    public int getColor(int pTintIndex) {
        return (pTintIndex == 0 ? this.toolColor : 16777215);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("tier.cloudtech." + this.cTier.pName).withStyle(
                Style.EMPTY.withColor(TextColor.parseColor(this.cTier.pColor))));
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack pStack) {
        MutableComponent nameComponent = (new TextComponent("").append(new TranslatableComponent(this.getDescriptionId(pStack)).getString()));
        Style nameStyle = Style.EMPTY.withColor(TextColor.parseColor(this.cTier.pColor));
        nameComponent.setStyle(nameStyle);
        return nameComponent;
    }
}
