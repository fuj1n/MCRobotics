package fuj1n.mcrobotics.tileentity;

import fuj1n.mcrobotics.ref.Version;

import fuj1n.mcrobotics.items.ItemBlockOS;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAssembler extends TileEntity implements IInventory {

	private ItemStack[] inventory = new ItemStack[getSizeInventory()];
	public AssemblyInventory assemblyInventory = new AssemblyInventory();

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		assemblyInventory.writeToBlockOS(inventory[0]);
		
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i) {
			if (this.inventory[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbtTagCompound.setTag("Items", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);

		NBTTagList nbttaglist = nbtTagCompound.getTagList("Items", 10);
		this.inventory = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.inventory.length) {
				this.inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		
		assemblyInventory.readFromBlockOS(inventory[0]);
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

			if (i == 0) {
				assemblyInventory.readFromBlockOS(itemstack);
			}
		}
	}

	protected void onSubInventoryChanged(){
		assemblyInventory.writeToBlockOS((inventory[0]));
	}
	
	@Override
	public String getInventoryName() {
		return "fuj1n.inventory.assembler";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	public class AssemblyInventory extends InventoryBasic {

		public AssemblyInventory() {
			super(Version.MODID + ".assemblyInventory", false, 7);
		}

		public void writeToBlockOS(ItemStack is) {
			if (is == null) {
				return;
			}

			if (!(is.getItem() instanceof ItemBlockOS)) {
				throw new IllegalArgumentException("Error writing inventory to BlockOS, the item " + is.getItem() + " is not an instance of ItemBlockOS.");
			}

			ItemBlockOS blockOS = (ItemBlockOS) is.getItem();

			for (char c = 'A'; c < 'E'; c++) {
				blockOS.setSensor(is, c, this.getStackInSlot(Math.abs('A' - c)));
			}

			for (byte i = 0; i < 3; i++) {
				blockOS.setActuator(is, (byte) (i + 1), this.getStackInSlot(4 + i));
			}
		}

		public void readFromBlockOS(ItemStack is) {
			if (is == null) {
				clearInventory();

				return;
			}

			if (!(is.getItem() instanceof ItemBlockOS)) {
				throw new IllegalArgumentException("Error reading inventory from BlockOS, the item " + is.getItem() + " is not an instance of ItemBlockOS.");
			}

			ItemBlockOS blockOS = (ItemBlockOS) is.getItem();

			for (char c = 'A'; c < 'E'; c++) {
				super.setInventorySlotContents(Math.abs('A' - c), blockOS.getSensor(is, c));
			}

			for (byte i = 0; i < 3; i++) {
				super.setInventorySlotContents(4 + i, blockOS.getActuator(is, (byte) (i + 1)));
			}
		}

		public void clearInventory() {
			for (int i = 0; i < this.getSizeInventory(); i++) {
				super.setInventorySlotContents(i, null);
			}
		}
		
		@Override
		public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
	    {
	        super.setInventorySlotContents(p_70299_1_, p_70299_2_);
	        
	        onSubInventoryChanged();
	    }

	}

}
