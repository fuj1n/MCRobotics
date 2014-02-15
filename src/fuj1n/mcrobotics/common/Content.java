package fuj1n.mcrobotics.common;

import cpw.mods.fml.common.registry.GameRegistry;
import fuj1n.mcrobotics.blocks.BlockAssembler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class Content {

	public static Block assembler;
	
	public Content(){
		addBlocks();
		registerBlocks();
	}
	
	public void addBlocks(){
		assembler = new BlockAssembler().setBlockName("mcrobotics.assembler")/*.func_149658_d("stone")*/.setCreativeTab(CreativeTabs.tabAllSearch);
	}
	
	public void registerBlocks(){
		GameRegistry.registerBlock(assembler, ItemBlock.class, "assembler", "MCRobotics");
	}
	
}
