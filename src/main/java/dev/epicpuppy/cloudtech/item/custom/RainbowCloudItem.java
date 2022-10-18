package dev.epicpuppy.cloudtech.item.custom;

import dev.epicpuppy.cloudtech.item.CloudtechItem;
import dev.epicpuppy.cloudtech.item.ICloudItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RainbowCloudItem extends Item implements ICloudItem {

    private static CloudTier cTier = CloudTier.T0;
    private static int tier = 0;
    private static int color;
    private static int cDelay = 4;

    public RainbowCloudItem(Properties pProperties) {
        super(pProperties);
        color = cTier.tColor;
    }

    public static void tick() {
        if (--cDelay <= 0) {
            tier++;
            if (tier > 15) {
                tier = 0;
            }
            cTier = CloudTier.valueOf("T" + tier);
            color = cTier.tColor;
            cDelay = 4;
        }
    }

    @Override
    public int getColor(int pTintIndex) {
        return (pTintIndex == 0 ? this.color : 16777215);
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
