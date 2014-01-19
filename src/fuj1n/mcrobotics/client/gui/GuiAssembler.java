package fuj1n.mcrobotics.client.gui;

import net.minecraft.util.StatCollector;

import fuj1n.mcrobotics.inventory.ContainerAssembler;
import fuj1n.mcrobotics.tileentity.TileEntityAssembler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;

public class GuiAssembler extends GuiContainer {

	private ResourceLocation background = new ResourceLocation("mcrobotics:gui/assembler.png");

	public GuiAssembler(EntityPlayer player, TileEntityAssembler assembler, int x, int y, int z) {
		super(new ContainerAssembler(player, assembler));
		field_147000_g = 190;
	}

	@Override
	protected void func_146979_b(int par1, int par2) {
		FontRenderer fontRenderer = this.field_146297_k.fontRenderer;
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.name"), 7, -6, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.playerinventory"), 8, (field_147000_g - 95) + 2, 0x404040);
		
		//Tips
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs"), 34, 10, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.a"), 36, 26, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.b"), 27, 45, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.c"), 27, 64, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.d"), 36, 84, 0x404040);
		
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs"), 97, 10, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs.one"), 135, 26, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs.two"), 144, 55, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs.three"), 135, 84, 0x404040);
	}

	@Override
	protected void func_146976_a(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.field_146297_k.getTextureManager().bindTexture(background);
		int l = (field_146294_l - field_146999_f) / 2;
		int i1 = (field_146295_m - field_147000_g) / 2;
		drawTexturedModalRect(l, i1, 0, 0, field_146999_f, field_147000_g);
		drawTexturedModalRect(l, i1 - 10, 0, 191, 63, 11);
	}
}
