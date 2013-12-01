package fuj1n.mcrobotics.inventory;

import fuj1n.mcrobotics.lib.assembly.EnumPartType;

import fuj1n.mcrobotics.lib.assembly.IAssemblyPart;
import fuj1n.mcrobotics.tileentity.TileEntityAssembler;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class SlotAssemblyPart extends Slot {
	
	TileEntityAssembler assembler;
	int slotAssignment;
	
	public SlotAssemblyPart(IInventory par1iInventory, int par2, int par3, int par4, int slotAssignment, TileEntityAssembler assembler) {
		super(par1iInventory, par2, par3, par4);
		
		this.assembler = assembler;
		this.slotAssignment = slotAssignment;
	}
	
    public boolean isItemValid(ItemStack par1ItemStack){
    	if(assembler.getStackInSlot(0) != null){
	    	if(!(par1ItemStack.getItem() instanceof IAssemblyPart)){
	    		IAssemblyPart part = (IAssemblyPart)par1ItemStack.getItem();
	    		EnumPartType type = part.getPartType(par1ItemStack);
	    		
	    		switch(slotAssignment){
	    		case 0:
	    			return type == EnumPartType.INPUT;
	    		case 1:
	    			return type == EnumPartType.OUTPUT;
	    		}
	    	}
    	}
    	return false;
    }

}
