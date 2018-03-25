package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LaunchCubeSmall extends CommandGroup {

	public LaunchCubeSmall() {
		double armSpeed = .3; //change for mark 3
		addSequential(new Hand(true));
		addSequential(new ArmMoveToPosition(70,-armSpeed),2);
		addSequential(new PneumaticSmallestLaunchCube());
		addSequential(new ArmMoveBack(150,armSpeed),2);
	}

	


}
