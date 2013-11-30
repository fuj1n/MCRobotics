package fuj1n.mcrobotics.lib.assembly;

import net.minecraft.item.ItemStack;

public interface IAssemblyPart {

	public PartType getPartType(ItemStack item);
	public boolean isActuator(ItemStack item);
	
}
