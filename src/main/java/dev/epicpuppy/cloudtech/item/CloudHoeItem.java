package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CloudHoeItem extends HoeItem implements ICloudItem {
    public final CloudTier cTier;
    private final int toolColor;

    public CloudHoeItem(CloudTier cTier, Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.cTier = cTier;
        this.toolColor = cTier.intColor;
    }

    public @NotNull CloudTier getCloudTier() {
        return this.cTier;
    }

    @Override
    public int getColor(int pTintIndex) {
        return (pTintIndex == 0 ? 16777215 : this.toolColor);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.cloudtech.durability").withStyle(
                    Style.EMPTY.withColor(TextColor.parseColor(this.cTier.hexColor))).append(String.valueOf(pStack.getMaxDamage() - pStack.getDamageValue())));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.cloudtech.view"));
        }
        pTooltipComponents.add(new TranslatableComponent("tier.cloudtech." + this.cTier.tierName).withStyle(
                Style.EMPTY.withColor(TextColor.parseColor(this.cTier.hexColor))));
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack pStack) {
        MutableComponent nameComponent = (new TextComponent("").append(new TranslatableComponent(this.getDescriptionId(pStack)).getString()));
        Style nameStyle = Style.EMPTY.withColor(TextColor.parseColor(this.cTier.hexColor));
        nameComponent.setStyle(nameStyle);
        return nameComponent;
    }
}
