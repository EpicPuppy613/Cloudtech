package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CloudSwordItem extends SwordItem {
    public final CloudTier cTier;
    private final int toolColor;

    public CloudSwordItem(CloudTier cTier, Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.cTier = cTier;
        this.toolColor = cTier.tColor;
    }

    public @NotNull CloudTier getCloudTier() {
        return this.cTier;
    }

    public int getColor(int pTintIndex) {
        return (pTintIndex == 0 ? 16777215 : this.toolColor);
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
