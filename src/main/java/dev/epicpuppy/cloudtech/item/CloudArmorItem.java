package dev.epicpuppy.cloudtech.item;

import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class CloudArmorItem extends ArmorItem {

    public final CloudTier cTier;
    private final int toolColor;

    public CloudArmorItem(CloudTier cTier, CloudArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
        this.cTier = cTier;
        this.toolColor = cTier.tColor;
    }



}
