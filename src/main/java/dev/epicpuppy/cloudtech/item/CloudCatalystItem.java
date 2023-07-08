package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.block.CloudtechBlock;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CloudCatalystItem extends CloudtechItem {

    public final int genTime;
    public final CloudtechBlock result;
    public CloudCatalystItem(int genTime, @NotNull CloudtechBlock result, CloudTier cTier, Properties pProperties) {
        super(cTier, pProperties);
        this.genTime = genTime;
        this.result = result;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TextComponent(""));
            pTooltipComponents.add(new TranslatableComponent("tooltip.cloudtech.catalyst.time", this.genTime));
            pTooltipComponents.add(new TextComponent(""));
        } else {
            pTooltipComponents.add(new TranslatableComponent( "tooltip.cloudtech.view"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
