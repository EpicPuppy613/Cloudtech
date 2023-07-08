package dev.epicpuppy.cloudtech.block.entity.machines;

import dev.epicpuppy.cloudtech.block.entity.CloudtechBlockEntities;
import dev.epicpuppy.cloudtech.item.CloudCatalystItem;
import dev.epicpuppy.cloudtech.screen.CloudSolidifierMenu;
import dev.epicpuppy.cloudtech.util.CloudTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class CloudSolidifierBlockEntity extends BlockEntity implements MenuProvider {
    public int genTime = 0;
    public int genTimeTotal = 0;
    private final int genSpeed;
    private final CloudTier cloudTier;

    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public CloudSolidifierBlockEntity(CloudTier cTier, BlockPos pPos, BlockState pBlockState) {
        super(CloudtechBlockEntities.CLOUD_SOLIDIFIER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.cloudTier = cTier;
        genSpeed = (int) Math.pow(2, cloudTier.tierMagnitude);
    }

    public CloudSolidifierBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(CloudTier.T0, pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container.cloudtech." + cloudTier.colorName + "_cloud_solidifier");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CloudSolidifierMenu(pContainerId, pPlayerInventory, this);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CloudSolidifierBlockEntity pBlockEntity) {
        if (!hasCatalyst(pBlockEntity) || !hasSpaceAbove(pBlockEntity)) {
            pBlockEntity.genTime = 0;
            return;
        }
        //Get catalyst items
        final CloudCatalystItem catalyst = (CloudCatalystItem) pBlockEntity.itemHandler.getStackInSlot(0).getItem();
        //Set gen time total
        pBlockEntity.genTimeTotal = (int) Math.ceil(catalyst.genTime / (float) pBlockEntity.genSpeed);
        //Check if gen cost is met
        if (pBlockEntity.genTime >= pBlockEntity.genTimeTotal) {
            //Set block above to cloud
            pLevel.setBlockAndUpdate(pPos.above(), catalyst.result.defaultBlockState());
            //Reset gen time
            pBlockEntity.genTime = 0;
        }
        //Increment gen time
        pBlockEntity.genTime++;
    }

    private static boolean hasSpaceAbove(CloudSolidifierBlockEntity entity) {
        assert entity.level != null;
        return entity.level.isEmptyBlock(entity.worldPosition.above());
    }

    private static boolean hasCatalyst(CloudSolidifierBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() instanceof CloudCatalystItem;
    }
}
