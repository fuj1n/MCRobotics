package fuj1n.mcrobotics.common;

import net.minecraftforge.common.Property;

import java.util.HashMap;

import java.io.File;
import net.minecraftforge.common.Configuration;

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
