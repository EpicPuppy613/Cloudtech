package dev.epicpuppy.cloudtech.events;

import dev.epicpuppy.cloudtech.Cloudtech;
import dev.epicpuppy.cloudtech.item.custom.RainbowCloudItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cloudtech.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        RainbowCloudItem.tick();
    }

}
