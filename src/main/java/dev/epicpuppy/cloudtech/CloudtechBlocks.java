package dev.epicpuppy.cloudtech;

import dev.epicpuppy.cloudtech.block.CloudBlock;
import dev.epicpuppy.cloudtech.block.CloudtechBlock;
import dev.epicpuppy.cloudtech.block.CloudtechBlockItem;
import dev.epicpuppy.cloudtech.block.ICloudBlock;
import dev.epicpuppy.cloudtech.block.machines.CloudSolidifierBlock;
import dev.epicpuppy.cloudtech.item.ICloudItem;
import dev.epicpuppy.cloudtech.util.CloudTier;
import dev.epicpuppy.cloudtech.util.TieredBlockRegisterHandler;
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

    private interface RegisterBlockOperator {
        public RegistryObject[] register(String color, int tier);
    }
    private static final MaterialColor[] blockColors = {
            MaterialColor.WOOL, MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_GRAY, MaterialColor.COLOR_RED,
            MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GREEN, MaterialColor.COLOR_GREEN,
            MaterialColor.COLOR_CYAN, MaterialColor.COLOR_LIGHT_BLUE, MaterialColor.COLOR_BLUE, MaterialColor.COLOR_PURPLE,
            MaterialColor.COLOR_MAGENTA, MaterialColor.COLOR_PINK, MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BLACK
    };

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cloudtech.MOD_ID);

    public static final TieredBlockRegisterHandler<CloudBlock> CLOUD_BLOCKS = generateBlocks(Cloudtech.COLORS, (color, tier) ->
            registerBlock(color + "_cloud_block", CloudTier.valueOf("T" + tier), () ->
                    new CloudBlock(CloudTier.valueOf("T" + tier), BlockBehaviour.Properties
                            .of(Material.WOOL).color(blockColors[tier]).sound(SoundType.WOOL)
                            .noOcclusion().strength(0.125f * (tier + 1))), CLOUDTECH_TAB)
    );
    public static final TieredBlockRegisterHandler<CloudtechBlock> CLOUD_FRAMES = generateBlocks(Cloudtech.COLORS, (color, tier) ->
            registerBlock(color + "_cloud_frame", CloudTier.valueOf("T" + tier), () ->
                    new CloudtechBlock(CloudTier.valueOf("T" + tier), BlockBehaviour.Properties
                            .of(Material.STONE).color(blockColors[tier]).requiresCorrectToolForDrops().sound(SoundType.STONE)
                            .noOcclusion().strength(1f + 0.25f * (tier + 1))), CLOUDTECH_TAB));
    public static final TieredBlockRegisterHandler<CloudSolidifierBlock> CLOUD_SOLIDIFIERS = generateBlocks(Cloudtech.COLORS, (color, tier) ->
            registerBlock(color + "_cloud_solidifier", CloudTier.valueOf("T" + tier), () ->
                    new CloudSolidifierBlock(CloudTier.valueOf("T" + tier), BlockBehaviour.Properties
                            .of(Material.STONE).color(blockColors[tier]).requiresCorrectToolForDrops().sound(SoundType.STONE)
                            .noOcclusion().strength(1f + 0.25f * (tier + 1))), CLOUDTECH_TAB));
    public static final TieredBlockRegisterHandler<CloudtechBlock> SOLID_CLOUDS = generateBlocks(Cloudtech.COLORS, (color, tier) ->
            registerBlock(color + "_solid_cloud", CloudTier.valueOf("T" + tier), () ->
                    new CloudtechBlock(CloudTier.valueOf("T" + tier), BlockBehaviour.Properties
                            .of(Material.STONE).color(blockColors[tier]).requiresCorrectToolForDrops().sound(SoundType.STONE)
                            .noOcclusion().strength(1f + 0.25f * (tier + 1))), CLOUDTECH_TAB));
    public static final TieredBlockRegisterHandler<CloudtechBlock> SOLID_CLOUD_BRICKS = generateBlocks(Cloudtech.COLORS, (color, tier) ->
            registerBlock(color + "_solid_cloud_bricks", CloudTier.valueOf("T" + tier), () ->
                    new CloudtechBlock(CloudTier.valueOf("T" + tier), BlockBehaviour.Properties
                            .of(Material.STONE).color(blockColors[tier]).requiresCorrectToolForDrops().sound(SoundType.STONE)
                            .noOcclusion().strength(1f + 0.25f * (tier + 1))), CLOUDTECH_TAB));
    public static <T> TieredBlockRegisterHandler<T> generateBlocks(String[] colors, RegisterBlockOperator register) {
        RegistryObject<T>[] blocks = new RegistryObject[colors.length];
        RegistryObject<CloudtechBlockItem>[] items = new RegistryObject[colors.length];
        int c = 0;
        for (String color : colors) {
            RegistryObject[] block = register.register(color, c);
            blocks[c] = block[0];
            items[c] = block[1];
            c++;
        }
        return new TieredBlockRegisterHandler<>(blocks, items);
    }

    private static RegistryObject[] registerBlock(String name, CloudTier tier, Supplier block, CreativeModeTab tab) {
        RegistryObject[] toReturn = new RegistryObject[2];
        toReturn[0] = BLOCKS.register(name, block);
        toReturn[1] = registerBlockItem(name, toReturn[0], tier, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<CloudtechBlockItem> registerBlockItem(String name, RegistryObject<T> block, CloudTier tier, CreativeModeTab tab) {
        return CloudtechItems.ITEMS.register(name, () -> new CloudtechBlockItem(block.get(), tier, new Item.Properties().tab(tab)));
    }

    public static void registerColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        registerBlockColor(blockColors, CLOUD_BLOCKS.BLOCKS);
        registerBlockColor(blockColors, CLOUD_FRAMES.BLOCKS);
        registerBlockColor(blockColors, CLOUD_SOLIDIFIERS.BLOCKS);
        registerBlockColor(blockColors, SOLID_CLOUDS.BLOCKS);
        registerBlockColor(blockColors, SOLID_CLOUD_BRICKS.BLOCKS);

        registerItemColor(itemColors, CLOUD_BLOCKS.ITEMS);
        registerItemColor(itemColors, CLOUD_FRAMES.ITEMS);
        registerItemColor(itemColors, CLOUD_SOLIDIFIERS.ITEMS);
        registerItemColor(itemColors, SOLID_CLOUDS.ITEMS);
        registerItemColor(itemColors, SOLID_CLOUD_BRICKS.ITEMS);
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
