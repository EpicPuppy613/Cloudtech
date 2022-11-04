package dev.epicpuppy.cloudtech;

import dev.epicpuppy.cloudtech.block.CloudBlock;
import dev.epicpuppy.cloudtech.block.CloudtechBlock;
import dev.epicpuppy.cloudtech.block.CloudtechBlockItem;
import dev.epicpuppy.cloudtech.block.ICloudBlock;
import dev.epicpuppy.cloudtech.item.ICloudItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static dev.epicpuppy.cloudtech.util.CloudtechCreativeTab.CLOUDTECH_TAB;

public class CloudtechBlocks {

    private static final MaterialColor[] blockColors = {
            MaterialColor.WOOL, MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_GRAY, MaterialColor.COLOR_RED,
            MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GREEN, MaterialColor.COLOR_GREEN,
            MaterialColor.COLOR_CYAN, MaterialColor.COLOR_LIGHT_BLUE, MaterialColor.COLOR_BLUE, MaterialColor.COLOR_PURPLE,
            MaterialColor.COLOR_MAGENTA, MaterialColor.COLOR_PINK, MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BLACK
    };

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cloudtech.MOD_ID);

    public static final RegistryObject[][] CLOUD_BLOCKS = generateCloudBlocks(Cloudtech.COLORS);
    public static final RegistryObject[][] CLOUD_FRAMES = generateCloudFrames(Cloudtech.COLORS);

    public static RegistryObject[][] generateCloudBlocks(String[] colors) {
        RegistryObject[][] clouds = new RegistryObject[2][16];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            RegistryObject[] cloud_block = registerBlock(color + "_cloud_block", CloudTier.valueOf("T" + finalC), () ->
                            new CloudBlock(CloudTier.valueOf("T" + finalC), BlockBehaviour.Properties
                                    .of(Material.WOOL).color(blockColors[finalC])
                                    .sound(SoundType.WOOL).noOcclusion().strength(0.125f * (finalC + 1))),
                    CLOUDTECH_TAB);
            clouds[0][c] = cloud_block[0];
            clouds[1][c] = cloud_block[1];
            c++;
        }
        return clouds;
    }

    public static RegistryObject[][] generateCloudFrames(String[] colors) {
        RegistryObject[][] clouds = new RegistryObject[2][16];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            RegistryObject[] cloud_block = registerBlock(color + "_cloud_frame", CloudTier.valueOf("T" + finalC), () ->
                            new CloudtechBlock(CloudTier.valueOf("T" + finalC), BlockBehaviour.Properties
                                    .of(Material.WOOL).color(blockColors[finalC])
                                    .sound(SoundType.WOOL).noOcclusion().strength(0.25f * (finalC + 1))),
                    CLOUDTECH_TAB);
            clouds[0][c] = cloud_block[0];
            clouds[1][c] = cloud_block[1];
            c++;
        }
        return clouds;
    }

    private static RegistryObject[] registerBlock(String name, CloudTier tier, Supplier block, CreativeModeTab tab) {
        RegistryObject[] toReturn = new RegistryObject[2];
        toReturn[0] = BLOCKS.register(name, block);
        toReturn[1] = registerBlockItem(name, toReturn[0], tier, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<CloudtechBlockItem> registerBlockItem(String name, RegistryObject<T> block, CloudTier tier, CreativeModeTab tab) {
        RegistryObject<CloudtechBlockItem> blockItem = CloudtechItems.ITEMS.register(name, () -> new CloudtechBlockItem(block.get(), tier, new Item.Properties().tab(tab)));
        return blockItem;
    }

    public static void registerColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        registerBlockColor(blockColors, CLOUD_BLOCKS[0]);
        registerBlockColor(blockColors, CLOUD_FRAMES[0]);

        registerItemColor(itemColors, CLOUD_BLOCKS[1]);
        registerItemColor(itemColors, CLOUD_FRAMES[1]);
    }

    private static <T extends ICloudBlock> void registerBlockColor(BlockColors blockColors, RegistryObject<T>[] objects) {
        for (RegistryObject<T> object : objects) {
            T item = object.get();
            blockColors.register(item, (Block) item);
        }
    }

    private static <T extends ICloudItem> void registerItemColor(ItemColors itemColors, RegistryObject<T>[] objects) {
        for (RegistryObject<T> object : objects) {
            T item = object.get();
            itemColors.register((stack, tint) -> item.getColor(tint), item);
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
