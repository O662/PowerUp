package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveToSwitch extends CommandGroup {
	
	

	public AutoDriveToSwitch() {
		requires(Robot.doubleUltrasonic);
		
		double distance = Robot.doubleUltrasonic.getDistanceFront()-10;
		addSequential(new AutoDriveStraight(distance,.3));
		// TODO Auto-generated constructor stub
	}

	public AutoDriveToSwitch(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}
