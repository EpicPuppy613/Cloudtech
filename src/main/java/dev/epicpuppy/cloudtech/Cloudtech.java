package dev.epicpuppy.cloudtech;

import com.mojang.logging.LogUtils;
import dev.epicpuppy.cloudtech.block.entity.CloudtechBlockEntities;
import dev.epicpuppy.cloudtech.screen.CloudSolidifierScreen;
import dev.epicpuppy.cloudtech.screen.CloudtechMenuTypes;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Cloudtech.MOD_ID)
public class Cloudtech
{
    public static final String[] COLORS = {
            "white", "light_gray", "gray", "red", "orange", "yellow", "lime", "green",
            "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown", "black"
    };
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "cloudtech";
    public ItemColors itemColors;

    public static final class ToolStats {
        public static final Integer[] LEVEL = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6};
        public static final Integer[] USES = {100, 125, 150, 200, 250, 300, 375, 475, 600, 750, 925, 1175, 1450, 1800, 2275, 2850};
        public static final Float[] SPEED = {4.0f, 4.5f, 5.0f, 6.0f, 6.5f, 7.0f, 7.5f, 8.0f, 8.25f, 8.5f, 8.75f, 9.0f, 9.25f, 9.5f, 9.75f, 10.0f};
        public static final Float[] DAMAGE = {0.0f, 0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f, 5.5f, 6.0f, 6.5f, 7.0f, 7.5f};
        public static final Integer[] ENCHANTING = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        public static final TagKey[] TAGS = {
                BlockTags.NEEDS_STONE_TOOL, BlockTags.NEEDS_STONE_TOOL, BlockTags.NEEDS_STONE_TOOL, BlockTags.NEEDS_IRON_TOOL,
                BlockTags.NEEDS_IRON_TOOL, BlockTags.NEEDS_IRON_TOOL, BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL,
                BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL,
                BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.NEEDS_DIAMOND_TOOL
        };
    }

    public static final class ArmorStats {
        public static final Integer[] DURABILITY = {5, 7, 9, 11, 14, 17, 20, 22, 24, 26, 28, 30, 33, 36, 39, 42, 45};
        public static final Float[] PROTECTION = {1.0f, 1.15f, 1.3f, 1.4f, 1.5f, 1.6f, 1.7f, 1.8f, 2.0f, 2.2f, 2.3f, 2.4f, 2.6f, 2.7f, 2.8f, 3.0f};
        public static final Float[] TOUGHNESS = {0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f, 1.2f, 1.4f, 1.6f, 1.8f, 2.0f, 2.2f, 2.4f, 2.6f, 2.8f, 3.0f};
        public static final Float[] KB_RESIST = {0f, 0f, 0f, 0f, 0f, 0f, 0.01f, 0.02f, 0.03f, 0.04f, 0.05f, 0.06f, 0.07f, 0.08f, 0.09f, 0.1f};
    }

    public static final class CatalystStats {
        // Time in ticks required to generate a cloud block of the given tier, higher tier solidifiers are faster but require power
        public static final Integer[] TIME = {4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072};
    }

    public Cloudtech()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CloudtechItems.register(eventBus);
        CloudtechBlocks.register(eventBus);

        CloudtechBlockEntities.register(eventBus);
        CloudtechMenuTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        int c = 0;
        for (String color : COLORS) {
            ItemBlockRenderTypes.setRenderLayer((Block) CloudtechBlocks.CLOUD_BLOCKS.BLOCKS[c].get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer((Block) CloudtechBlocks.CLOUD_FRAMES.BLOCKS[c].get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer((Block) CloudtechBlocks.CLOUD_SOLIDIFIERS.BLOCKS[c].get(), RenderType.translucent());
            c++;
        }

        MenuScreens.register(CloudtechMenuTypes.CLOUD_SOLIDIFIER_MENU.get(), CloudSolidifierScreen::new);

        CloudtechItems.registerColors();
        CloudtechBlocks.registerColors();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Hello from setup");
    }

    public ItemColors getItemColors() {
        return this.itemColors;
    }

}
