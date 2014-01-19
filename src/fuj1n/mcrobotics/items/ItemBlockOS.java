package fuj1n.mcrobotics.items;

import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

/**
 * NBT Structure:
 * Assembly - A compound tag for the assembly
 * Assembly.Sensor(letter) - Sensors
 * Assembly.Actuator(id) - Actuators
 */
public class ItemBlockOS extends Item{

	public ItemBlockOS() {
	}
	
	public void setSensor(ItemStack is, char letter, ItemStack value){
		if(is.getTagCompound() == null || is.getTagCompound().getCompoundTag("Assembly") != null){
			if(is.getTagCompound() != null){
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			}else{
				is.setTagCompound(new NBTTagCompound());
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			}
		}
		
		NBTTagCompound itemData = new NBTTagCompound();
		value.writeToNBT(itemData);
		is.getTagCompound().getCompoundTag("Assembly").setTag("Sensor" + Character.toUpperCase(letter), itemData);
	}
	
	public void setActuator(ItemStack is, int i, ItemStack value){
		if(is.getTagCompound() == null || is.getTagCompound().getCompoundTag("Assembly") != null){
			if(is.getTagCompound() != null){
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			}else{
				is.setTagCompound(new NBTTagCompound());
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			}
		}
		
		NBTTagCompound itemData = new NBTTagCompound();
		value.writeToNBT(itemData);
		is.getTagCompound().getCompoundTag("Assembly").setTag("Actuator" + i, itemData);
	}
	
}
