package fuj1n.mcrobotics.lib.assembly;

import fuj1n.mcrobotics.lib.assembly.part.IPartHandler;

import fuj1n.mcrobotics.lib.assembly.*;
import net.minecraft.item.ItemStack;

public interface IAssemblyPart {

	public EnumPartType getPartType(ItemStack item);

	public IPartHandler getPartHandler(ItemStack item);

}
