package fuj1n.mcrobotics.items;

import fuj1n.mcrobotics.lib.assembly.part.IPartHandler;

import fuj1n.mcrobotics.lib.assembly.IAssemblyPart;

import fuj1n.mcrobotics.lib.assembly.*;
import net.minecraft.item.*;

public class ItemAssemblyPart extends Item implements IAssemblyPart {

	public ItemAssemblyPart() {
		this.setHasSubtypes(true);
	}

	@Override
	public EnumPartType getPartType(ItemStack item) {
		//TODO return an appropriate part type based on meta
		return null;
	}

	@Override
	public IPartHandler getPartHandler(ItemStack item) {
		// TODO return an appropriate handler based on meta
		return null;
	}

}
