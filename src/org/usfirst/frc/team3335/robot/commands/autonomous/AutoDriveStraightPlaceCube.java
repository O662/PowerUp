package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.commands.Hand;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveStraightPlaceCube extends CommandGroup {
	
	public AutoDriveStraightPlaceCube() {
		
		addSequential(new AutoDriveStraight(140,.7));
		addSequential(new Hand(true));
		//add command for launch cube
		
	}

}
