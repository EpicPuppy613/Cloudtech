package dev.epicpuppy.cloudtech;

import com.mojang.logging.LogUtils;
import dev.epicpuppy.cloudtech.block.ModBlocks;
import dev.epicpuppy.cloudtech.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
            "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
            "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"
    };
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "cloudtech";

    public Cloudtech()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        int c = 0;
        for (String color : COLORS) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOUD_BLOCKS[c].get(), RenderType.translucent());
            c++;
        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Hello from setup");
    }

}
