package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

//Deprecated due to warning below
//@Deprecated
public class AutoDriveToSwitch extends Command {

	/**
	 * TODO: WARNING - this command group will not function as expected, due to
	 * getting the ultrasonic distance at the time the command is constructed,
	 * not at the time the command is started (running).
	 * 
	 */
	/*
	public AutoDriveToSwitch() {
		this("AutoDriveToSwitch");
	}

	public AutoDriveToSwitch(String name) {
		super(name);
		requires(Robot.doubleUltrasonic);
		
		double distance = Robot.doubleUltrasonic.getDistanceFront()-10;
		addSequential(new AutoDriveStraight(distance,.3));
	}
	*/
	public AutoDriveToSwitch() {
		this("AutoDriveToSwitch");
	}
	
	public AutoDriveToSwitch(String name) {
		super(name);
		requires(Robot.doubleUltrasonic);
	}
	
	public static double GetDistance() {
		double distance = Robot.doubleUltrasonic.getDistanceFront()-10;
		return distance;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
