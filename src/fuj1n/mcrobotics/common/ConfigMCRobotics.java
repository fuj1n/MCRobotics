package fuj1n.mcrobotics.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigMCRobotics {
	
	public ConfigMCRobotics(File configLocation){
		Configuration config = new Configuration(configLocation);
		
		config.load();
		
		//Config options
		
		if(config.hasChanged()){
			config.save();
		}
	}
	
}
