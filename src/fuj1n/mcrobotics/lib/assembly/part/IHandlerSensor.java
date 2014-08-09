package fuj1n.mcrobotics.lib.assembly.part;

import net.minecraft.entity.Entity;

public interface IHandlerSensor extends IPartHandler {

	public boolean sense(Entity blockosentity /*TODO replace with actual entity*/);

}
