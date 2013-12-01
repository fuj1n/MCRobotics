package fuj1n.mcrobotics.inventory;

import net.minecraft.inventory.Slot;

import fuj1n.mcrobotics.tileentity.TileEntityAssembler;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.inventory.Container;

public class ContainerAssembler extends Container {

	EntityPlayer player;
	TileEntityAssembler assembler;

	public ContainerAssembler(EntityPlayer player, TileEntityAssembler assembler) {
		this.player = player;
		this.assembler = assembler;

		bindContainerInventory();
		bindPlayerInventory();
	}

	public void bindPlayerInventory() {
		for (int i = 0; i < 3; ++i) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(player.inventory, i1 + i * 9 + 9, 8 + i1 * 18, 84 + i * 18 + 24));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142 + 24));
		}
	}

	public void bindContainerInventory() {
		this.addSlotToContainer(new Slot(assembler, 0, 80, 51));
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		//TODO replace with TileEntity call
		return true;
	}

}
