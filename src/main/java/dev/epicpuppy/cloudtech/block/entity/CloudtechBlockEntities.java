package dev.epicpuppy.cloudtech.block.entity;

import dev.epicpuppy.cloudtech.Cloudtech;
import dev.epicpuppy.cloudtech.CloudtechBlocks;
import dev.epicpuppy.cloudtech.block.entity.machines.CloudSolidifierBlockEntity;
import dev.epicpuppy.cloudtech.block.machines.CloudSolidifierBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CloudtechBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Cloudtech.MOD_ID);

    private static final RegistryObject<CloudSolidifierBlock>[] CLOUD_SOLIDIFIER_BLOCKS = CloudtechBlocks.CLOUD_SOLIDIFIERS.BLOCKS;

    public static final RegistryObject<BlockEntityType<CloudSolidifierBlockEntity>> CLOUD_SOLIDIFIER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("cloud_solidifier_block_entity", () ->
                    BlockEntityType.Builder.of(CloudSolidifierBlockEntity::new,
                            CLOUD_SOLIDIFIER_BLOCKS[0].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[1].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[2].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[3].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[4].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[5].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[6].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[7].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[8].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[9].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[10].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[11].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[12].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[13].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[14].get(),
                            CLOUD_SOLIDIFIER_BLOCKS[15].get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
