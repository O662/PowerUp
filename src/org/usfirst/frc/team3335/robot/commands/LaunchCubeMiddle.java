package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LaunchCubeMiddle extends CommandGroup {

	public LaunchCubeMiddle() {
		double armSpeed = .3; //change for mark 3
		
		addSequential(new ArmMoveToPosition(70,-armSpeed),2);
		addSequential(new PneumaticSmallLaunchCube());
	}



}
