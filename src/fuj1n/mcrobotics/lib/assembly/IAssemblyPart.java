package fuj1n.mcrobotics.lib.assembly;

import net.minecraft.item.ItemStack;

public interface IAssemblyPart {

	public EnumPartType getPartType(ItemStack item);
	
}
