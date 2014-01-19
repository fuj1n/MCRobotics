package fuj1n.mcrobotics.common;

import fuj1n.mcrobotics.inventory.ContainerAssembler;

import cpw.mods.fml.common.network.IGuiHandler;
import fuj1n.mcrobotics.client.gui.GuiAssembler;
import fuj1n.mcrobotics.tileentity.TileEntityAssembler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case 0:
			return new ContainerAssembler(player, (TileEntityAssembler)world.func_147438_o(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case 0:
			return new GuiAssembler(player, (TileEntityAssembler)world.func_147438_o(x, y, z), x, y, z);
		}
		return null;
	}

}
