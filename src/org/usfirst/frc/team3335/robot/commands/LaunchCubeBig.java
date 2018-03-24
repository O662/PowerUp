package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LaunchCubeBig extends CommandGroup {

	public LaunchCubeBig() {
		double armSpeed = .3; //change for mark 3
		
		addSequential(new ArmMoveToPosition(70,-armSpeed),2);
		addSequential(new PneumaticLaunchCube());
	}

	

}
