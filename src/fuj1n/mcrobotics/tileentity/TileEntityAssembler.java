package fuj1n.mcrobotics.tileentity;

import net.minecraft.inventory.InventoryBasic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAssembler extends TileEntity implements IInventory {

	private ItemStack[] inventory = new ItemStack[getSizeInventory()];
	public AssemblyInventory assemblyInventory = new AssemblyInventory();
	
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return (i >= 0 && i < inventory.length) ? inventory[i] : null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.inventory[i] != null) {
			ItemStack itemstack;

			if (this.inventory[i].stackSize <= j) {
				itemstack = this.inventory[i];
				this.inventory[i] = null;
				return itemstack;
			} else {
				itemstack = this.inventory[i].splitStack(j);

				if (this.inventory[i].stackSize == 0) {
					this.inventory[i] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (inventory != null) {
			return getStackInSlot(i);
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if (i >= 0 && i < inventory.length) {
			inventory[i] = itemstack;
		}
	}

	@Override
	public String getInvName() {
		return "fuj1n.inventory.assembler";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public void onInventoryChanged() {

	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
	public class AssemblyInventory extends InventoryBasic {

		public AssemblyInventory() {
			super("assemblyInventory", false, 7);
		}
		
	}

}
