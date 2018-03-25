package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LaunchCubeBig extends CommandGroup {

	public LaunchCubeBig() {
		double armSpeed = .3; //change for mark 3
		addSequential(new Hand(true));
		addSequential(new ArmMoveToPosition(110,-armSpeed),2);
		addSequential(new PneumaticLaunchCube());
		addSequential(new ArmMoveBack(150,armSpeed),2);
	}

	

}
