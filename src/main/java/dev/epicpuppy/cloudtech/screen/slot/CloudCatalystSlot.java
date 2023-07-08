package dev.epicpuppy.cloudtech.screen.slot;

import dev.epicpuppy.cloudtech.item.CloudCatalystItem;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CloudCatalystSlot extends SlotItemHandler {

    public CloudCatalystSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(net.minecraft.world.item.ItemStack stack) {
        return stack.getItem() instanceof CloudCatalystItem;
    }
}
