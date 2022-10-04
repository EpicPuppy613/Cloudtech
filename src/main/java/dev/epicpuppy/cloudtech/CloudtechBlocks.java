package dev.epicpuppy.cloudtech;

import dev.epicpuppy.cloudtech.Cloudtech;
import dev.epicpuppy.cloudtech.CloudtechItems;
import dev.epicpuppy.cloudtech.block.CloudtechBlockItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
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
            MaterialColor.WOOL, MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK,
            MaterialColor.COLOR_RED, MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GREEN,
            MaterialColor.COLOR_GREEN, MaterialColor.COLOR_CYAN, MaterialColor.COLOR_LIGHT_BLUE, MaterialColor.COLOR_BLUE,
            MaterialColor.COLOR_PURPLE, MaterialColor.COLOR_MAGENTA, MaterialColor.COLOR_PINK, MaterialColor.COLOR_BROWN
    };

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cloudtech.MOD_ID);

    public static final RegistryObject<Block>[] CLOUD_BLOCKS = generateCloudBlocks(Cloudtech.COLORS);

    public static RegistryObject<Block>[] generateCloudBlocks(String[] colors) {
        RegistryObject<Block>[] clouds = new RegistryObject[16];
        int c = 0;
        for (String color : colors) {
            int finalC = c;
            clouds[c] = registerBlock(color + "_cloud_block", CloudTier.valueOf("T" + finalC), () ->
                    new GlassBlock(BlockBehaviour.Properties
                            .of(Material.WOOL).color(blockColors[finalC])
                            .sound(SoundType.WOOL).noOcclusion().strength(0.125f * (finalC + 1))),
                    CLOUDTECH_TAB);
            c++;
        }
        return clouds;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, CloudTier tier, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tier, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CloudTier tier, CreativeModeTab tab) {
        return CloudtechItems.ITEMS.register(name, () -> new CloudtechBlockItem(block.get(), tier, new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
