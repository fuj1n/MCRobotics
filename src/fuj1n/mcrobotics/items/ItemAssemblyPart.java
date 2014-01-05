package fuj1n.mcrobotics.items;

import fuj1n.mcrobotics.lib.assembly.EnumPartType;
import net.minecraft.item.ItemStack;

import fuj1n.mcrobotics.lib.assembly.IAssemblyPart;

import net.minecraft.item.Item;

public class ItemAssemblyPart extends Item implements IAssemblyPart {

	public ItemAssemblyPart(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public EnumPartType getPartType(ItemStack item) {
		//TODO return an appropriate part type based on meta
		return null;
	}

}
