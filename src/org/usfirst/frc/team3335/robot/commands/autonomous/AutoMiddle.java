package org.usfirst.frc.team3335.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMiddle extends CommandGroup {

	public AutoMiddle() {
		addSequential(new AutoDriveTurnToScale(20,.5));
		addSequential(new AutoDriveStraight(85,.3));
	}

	

}
