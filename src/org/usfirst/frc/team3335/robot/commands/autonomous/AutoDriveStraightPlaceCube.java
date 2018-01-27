package org.usfirst.frc.team3335.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveStraightPlaceCube extends CommandGroup {
	
	public AutoDriveStraightPlaceCube() {
		
		addSequential(new AutoDriveStraight(140,.7));
		//add command for launch cube
		
	}

}
