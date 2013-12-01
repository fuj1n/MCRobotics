package fuj1n.mcrobotics.common;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.registry.GameRegistry;

import fuj1n.mcrobotics.blocks.BlockAssembler;
import net.minecraft.block.Block;

public class Content {

	public static Block assembler;
	
	public Content(){
		addBlocks();
		registerBlocks();
	}
	
	public void addBlocks(){
		assembler = new BlockAssembler(512).setCreativeTab(CreativeTabs.tabAllSearch);
	}
	
	public void registerBlocks(){
		GameRegistry.registerBlock(assembler);
	}
	
}
