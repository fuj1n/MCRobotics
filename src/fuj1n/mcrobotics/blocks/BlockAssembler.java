package fuj1n.mcrobotics.blocks;

import net.minecraft.block.material.MapColor;

import fuj1n.mcrobotics.tileentity.TileEntityAssembler;

import fuj1n.mcrobotics.MCRobotics;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public class BlockAssembler extends BlockContainer {

	public BlockAssembler() {
		super(Material.field_151573_f);
	}

	@Override
	public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		par5EntityPlayer.openGui(MCRobotics.instance, 0, par1World, par2, par3, par4);
		return true;
	}

	@Override
	public TileEntity func_149915_a(World world, int meta) {
		return new TileEntityAssembler();
	}

}
