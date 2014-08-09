package fuj1n.mcrobotics;

import fuj1n.mcrobotics.ref.Version;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import fuj1n.mcrobotics.common.*;

/**
 * NXT name proposals(obviously cannot use NXT)
 * BlockOS - (as suggested by Chaz_Turbo)
 *
 */

@Mod(modid = Version.MODID, name = "MCRobotics", version = Version.VERSION)
public class MCRobotics {

	@Instance("MCRobotics")
	public static MCRobotics instance;

	@SidedProxy(clientSide = "fuj1n.mcrobotics.client.ClientProxyMCRobotics", serverSide = "fuj1n.mcrobotics.common.CommonProxyMCRobotics")
	public static CommonProxyMCRobotics proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		new ConfigMCRobotics(event.getSuggestedConfigurationFile());

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		new Content();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.Init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

}
