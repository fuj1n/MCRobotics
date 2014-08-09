package fuj1n.mcrobotics.items;

import cpw.mods.fml.common.Loader;

import net.minecraft.util.EnumChatFormatting;

import cpw.mods.fml.relauncher.*;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

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

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag1) {
		if (org.lwjgl.input.Keyboard.isKeyDown(42) || org.lwjgl.input.Keyboard.isKeyDown(54)) {
			list.add("Assembly Information: ");
			list.add(EnumChatFormatting.ITALIC.GREEN + "Sensors: ");
			for (char c = 'A'; c < 'E'; c++) {
				ItemStack sensor = getSensor(is, c);

				if (sensor != null) {
					list.add(c + ": " + sensor.getDisplayName());
				} else {
					list.add(c + ": ");
				}
			}
			list.add(EnumChatFormatting.ITALIC.GOLD + "Actuators: ");
			for (byte b = 1; b < 4; b++) {
				ItemStack actuator = getActuator(is, b);

				if (actuator != null) {
					list.add(b + ": " + actuator.getDisplayName());
				} else {
					list.add(b + ": ");
				}
			}
		} else {
			list.add(EnumChatFormatting.GRAY + "Hold <" + EnumChatFormatting.DARK_PURPLE + "Shift" + EnumChatFormatting.GRAY + "> for assembly information...");
		}
	}
}
