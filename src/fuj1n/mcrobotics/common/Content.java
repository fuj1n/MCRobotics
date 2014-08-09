package fuj1n.mcrobotics.common;

import fuj1n.mcrobotics.tileentity.TileEntityAssembler;

import fuj1n.mcrobotics.ref.Version;

import fuj1n.mcrobotics.items.ItemBlockOS;

import cpw.mods.fml.common.registry.GameRegistry;
import fuj1n.mcrobotics.blocks.BlockAssembler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

public class Content {

	public static Block assembler;
	public static Item blockOS;

	public Content() {
		addBlocks();
		registerBlocks();
		addItems();
		registerItems();
		registerTileEntities();
	}

	public void addBlocks() {
		assembler = new BlockAssembler().setBlockName("mcrobotics.assembler").setBlockTextureName("stone").setCreativeTab(CreativeTabs.tabAllSearch);
	}

	public void registerBlocks() {
		GameRegistry.registerBlock(assembler, ItemBlock.class, "assembler");
	}

	public void addItems() {
		blockOS = new ItemBlockOS().setUnlocalizedName("mcrobotics.blockos").setTextureName("stick").setCreativeTab(CreativeTabs.tabAllSearch);
	}

	public void registerItems() {
		GameRegistry.registerItem(blockOS, "blockos", Version.MODID);
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityAssembler.class, Version.MODID + ".assembler");
	}

}
