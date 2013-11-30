package fuj1n.mcrobotics.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public class BlockAssembler extends BlockContainer {

	public BlockAssembler(int par1) {
		super(par1, Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}

}
