package org.usfirst.frc.team3335.robot.commands.autonomous;

//import org.usfirst.frc.team3335.robot.commands.ArmLower;
import org.usfirst.frc.team3335.robot.commands.Hand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoPlaceCube extends CommandGroup {
	
	public AutoPlaceCube() {
		
		addSequential(new AutoDriveStraight(140,.7));
		
		//addSequential(new ArmLower());
		
		addSequential(new Hand(true));
		
	}

}
