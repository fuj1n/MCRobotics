package fuj1n.mcrobotics.items;

import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

/**
 * NBT Structure:
 * Assembly - A compound tag for the assembly
 * Assembly.Sensor{UCase_letter} - Sensors
 * Assembly.Actuator{id} - Actuators
 */
public class ItemBlockOS extends Item {

	public ItemBlockOS() {
	}

	public void setSensor(ItemStack is, char letter, ItemStack value) {
		if (is == null) {
			return;
		}

		if (Character.toUpperCase(letter) < 'A' || Character.toUpperCase(letter) > 'D') {
			throw new IllegalArgumentException("Failed setting sensor " + Character.toUpperCase(letter) + ", only A-D are supported.");
		}

		if (is.getTagCompound() == null || is.getTagCompound().getCompoundTag("Assembly") == null) {
			if (is.getTagCompound() != null) {
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			} else {
				is.setTagCompound(new NBTTagCompound());
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			}
		}

		if (value == null) {
			is.getTagCompound().getCompoundTag("Assembly").removeTag("Sensor" + Character.toUpperCase(letter));
			
			return;
		}

		NBTTagCompound itemData = new NBTTagCompound();
		value.writeToNBT(itemData);
		is.getTagCompound().getCompoundTag("Assembly").setTag("Sensor" + Character.toUpperCase(letter), itemData);
	}

	public void setActuator(ItemStack is, byte i, ItemStack value) {
		if (is == null) {
			return;
		}

		if (i < 1 || i > 3) {
			throw new IllegalArgumentException("Failed setting actuator " + i + ", only 1-3 are supported.");
		}

		if (is.getTagCompound() == null || is.getTagCompound().getCompoundTag("Assembly") == null) {
			if (is.getTagCompound() != null) {
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			} else {
				is.setTagCompound(new NBTTagCompound());
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());
			}
		}

		if (value == null) {
			is.getTagCompound().getCompoundTag("Assembly").removeTag("Actuator" + i);
			
			return;
		}
		
		NBTTagCompound itemData = new NBTTagCompound();
		value.writeToNBT(itemData);
		is.getTagCompound().getCompoundTag("Assembly").setTag("Actuator" + i, itemData);
	}

	public ItemStack getSensor(ItemStack is, char letter) {
		if (is == null) {
			return null;
		}

		if (Character.toUpperCase(letter) < 'A' || Character.toUpperCase(letter) > 'D') {
			throw new IllegalArgumentException("Failed getting sensor " + Character.toUpperCase(letter) + ", only A-D are supported.");
		}

		if (is.getTagCompound() == null || is.getTagCompound().getCompoundTag("Assembly") == null) {
			if (is.getTagCompound() != null) {
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());

				return null;
			} else {
				is.setTagCompound(new NBTTagCompound());
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());

				return null;
			}
		}

		NBTTagCompound itemData = (NBTTagCompound) is.getTagCompound().getCompoundTag("Assembly").getTag("Sensor" + Character.toUpperCase(letter));

		if (itemData == null) {
			return null;
		}

		return ItemStack.loadItemStackFromNBT(itemData);
	}

	public ItemStack getActuator(ItemStack is, byte i) {
		if (is == null) {
			return null;
		}

		if (i < 1 || i > 3) {
			throw new IllegalArgumentException("Failed getting actuator " + i + ", only 1-3 are supported.");
		}

		if (is.getTagCompound() == null || is.getTagCompound().getCompoundTag("Assembly") == null) {
			if (is.getTagCompound() != null) {
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());

				return null;
			} else {
				is.setTagCompound(new NBTTagCompound());
				is.getTagCompound().setTag("Assembly", new NBTTagCompound());

				return null;
			}
		}

		NBTTagCompound itemData = (NBTTagCompound) is.getTagCompound().getCompoundTag("Assembly").getTag("Actuator" + i);

		if (itemData == null) {
			return null;
		}

		return ItemStack.loadItemStackFromNBT(itemData);
	}

}
