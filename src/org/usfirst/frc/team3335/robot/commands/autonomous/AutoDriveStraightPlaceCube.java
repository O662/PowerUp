package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallLaunchCube;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveStraightPlaceCube extends CommandGroup {
	
	public AutoDriveStraightPlaceCube() {
		
		addSequential(new AutoDriveStraight(80,.3));
		//addSequential(new ArmMove(-.3));
		addSequential(new PneumaticSmallLaunchCube());
		//add command for launch cube
		
	}

}
