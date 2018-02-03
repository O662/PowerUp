package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BackUpToWall extends Command {
	double distance,speed;
	public BackUpToWall(double speed) {
		// TODO Auto-generated constructor stub
		requires(Robot.doubleUltrasonic);
		double distance = Robot.doubleUltrasonic.getDistance();
		this.speed = speed;
	}

	

	protected void initialize() {
		Robot.driveTrain.setBrake(true);
		Robot.driveTrain.zeroEncoders();
	}
	
	public void execute() {
		Robot.driveTrain.drive(speed, speed);
	}
	@Override
	protected boolean isFinished() {
		double driveTrainDist = Robot.driveTrain.getDistance();
		if(Math.abs(driveTrainDist) >= distance) {
			return true;
		}
		else {
			return false;
		}
		// TODO Auto-generated method stub
		//return false;
	}

}



