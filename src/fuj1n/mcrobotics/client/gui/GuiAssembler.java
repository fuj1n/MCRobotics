package fuj1n.mcrobotics.client.gui;

import net.minecraft.util.StatCollector;

import fuj1n.mcrobotics.inventory.ContainerAssembler;
import fuj1n.mcrobotics.tileentity.TileEntityAssembler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAssembler extends GuiContainer {

	private ResourceLocation background = new ResourceLocation("mcrobotics:gui/assembler.png");

	public GuiAssembler(EntityPlayer player, TileEntityAssembler assembler, int x, int y, int z) {
		super(new ContainerAssembler(player, assembler));
		ySize = 190;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
//		fontRenderer.drawString("Assembler", 7, -6, 0x404040);
//		fontRenderer.drawString("Inventory", 8, (ySize - 95) + 2, 0x404040);
//		
//		//Tips
//		fontRenderer.drawString("Inputs", 38, 10, 0x404040);
//		fontRenderer.drawString("A", 36, 26, 0x404040);
//		fontRenderer.drawString("B", 27, 45, 0x404040);
//		fontRenderer.drawString("C", 27, 64, 0x404040);
//		fontRenderer.drawString("D", 36, 84, 0x404040);
//		
//		fontRenderer.drawString("Outputs", 102, 10, 0x404040);
//		fontRenderer.drawString("1", 135, 26, 0x404040);
//		fontRenderer.drawString("2", 144, 55, 0x404040);
//		fontRenderer.drawString("3", 135, 84, 0x404040);
		
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.name"), 7, -6, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.playerinventory"), 8, (ySize - 95) + 2, 0x404040);
		
		//Tips
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs"), 38, 10, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.a"), 36, 26, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.b"), 27, 45, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.c"), 27, 64, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.inputs.d"), 36, 84, 0x404040);
		
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs"), 102, 10, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs.one"), 135, 26, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs.two"), 144, 55, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("mcrobotics.gui.assembler.outputs.three"), 135, 84, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(background);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
		drawTexturedModalRect(l, i1 - 10, 0, 191, 63, 11);
	}
}
