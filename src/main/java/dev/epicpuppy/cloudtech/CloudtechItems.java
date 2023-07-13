package dev.epicpuppy.cloudtech;

import dev.epicpuppy.cloudtech.item.*;
import dev.epicpuppy.cloudtech.item.custom.RainbowCloudItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.epicpuppy.cloudtech.util.CloudtechCreativeTab.CLOUDTECH_GEAR;
import static dev.epicpuppy.cloudtech.util.CloudtechCreativeTab.CLOUDTECH_TAB;

public class CloudtechItems {

    private interface RegisterItemOperator {
        public RegistryObject register(String color, int tier);
    }
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cloudtech.MOD_ID);
    public static final RegistryObject<CloudtechItem>[] CLOUDS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + tier), new Item.Properties().tab(CLOUDTECH_TAB))));
    public static final RegistryObject<CloudtechItem>[] INGOTS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_ingot", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + tier), new Item.Properties().tab(CLOUDTECH_TAB))));
    public static final RegistryObject<CloudtechItem>[] CORES = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_core", () ->
                    new CloudtechItem(CloudTier.valueOf("T" + tier), new Item.Properties().tab(CLOUDTECH_TAB))));
    public static final RegistryObject<CloudCatalystItem>[] CATALYSTS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_catalyst", () ->
                    new CloudCatalystItem(Cloudtech.CatalystStats.TIME[tier], CloudtechBlocks.CLOUD_BLOCKS.BLOCKS[tier].get(),
                            CloudTier.valueOf("T" + tier), new Item.Properties().tab(CLOUDTECH_TAB))));
    public static final RegistryObject<CloudSwordItem>[] SWORDS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_sword", () ->
                    new CloudSwordItem(CloudTier.valueOf("T" + tier), CloudtechTiers.TIERS[tier], 2, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudPickaxeItem>[] PICKAXES = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_pickaxe", () ->
                    new CloudPickaxeItem(CloudTier.valueOf("T" + tier), CloudtechTiers.TIERS[tier], 1, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudAxeItem>[] AXES = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_axe", () ->
                    new CloudAxeItem(CloudTier.valueOf("T" + tier), CloudtechTiers.TIERS[tier], 4, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudShovelItem>[] SHOVELS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_shovel", () ->
                    new CloudShovelItem(CloudTier.valueOf("T" + tier), CloudtechTiers.TIERS[tier], 0, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudHoeItem>[] HOES = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_hoe", () ->
                    new CloudHoeItem(CloudTier.valueOf("T" + tier), CloudtechTiers.TIERS[tier], -1, -2.4f,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudArmorItem>[] HELMETS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_helmet", () ->
            new CloudArmorItem(CloudTier.valueOf("T" + tier), CloudtechArmorMaterials.MATERIALS[tier], EquipmentSlot.HEAD,
                    new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudArmorItem>[] CHESTPLATES = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_chestplate", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + tier), CloudtechArmorMaterials.MATERIALS[tier], EquipmentSlot.CHEST,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudArmorItem>[] LEGGINGS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_leggings", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + tier), CloudtechArmorMaterials.MATERIALS[tier], EquipmentSlot.LEGS,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<CloudArmorItem>[] BOOTS = generateItems(Cloudtech.COLORS, (color, tier) ->
            ITEMS.register(color + "_cloud_boots", () ->
                    new CloudArmorItem(CloudTier.valueOf("T" + tier), CloudtechArmorMaterials.MATERIALS[tier], EquipmentSlot.FEET,
                            new Item.Properties().tab(CLOUDTECH_GEAR))));
    public static final RegistryObject<RainbowCloudItem> RAINBOW_CLOUD = ITEMS.register("rainbow_cloud", () ->
            new RainbowCloudItem(new Item.Properties().tab(CLOUDTECH_TAB)));

    public static <T> RegistryObject<T>[] generateItems(String[] colors, RegisterItemOperator register) {
        RegistryObject<T>[] items = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            items[c] = register.register(color, c);
            c++;
        }
        return items;
    }
    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);

    }
    public static void registerColors() {
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        itemColors.register((stack, tint) -> RAINBOW_CLOUD.get().getColor(tint), RAINBOW_CLOUD.get());

        registerColor(itemColors, CLOUDS);
        registerColor(itemColors, INGOTS);
        registerColor(itemColors, CORES);
        registerColor(itemColors, CATALYSTS);
        registerColor(itemColors, SWORDS);
        registerColor(itemColors, PICKAXES);
        registerColor(itemColors, AXES);
        registerColor(itemColors, SHOVELS);
        registerColor(itemColors, HOES);
        registerColor(itemColors, HELMETS);
        registerColor(itemColors, CHESTPLATES);
        registerColor(itemColors, LEGGINGS);
        registerColor(itemColors, CHESTPLATES);
        registerColor(itemColors, BOOTS);

    }
    private static <T extends ICloudItem> void registerColor(ItemColors itemColors, RegistryObject<T>[] objects) {
        for (RegistryObject<T> object : objects) {
            T item = object.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
    }
}
