package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BackUpToWall extends Command {
	private final double distance;
	private final double speed;

	public BackUpToWall(double speed) {
		requires(Robot.doubleUltrasonic);
		distance = Robot.doubleUltrasonic.getDistance();
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
		if (Math.abs(driveTrainDist) >= distance) {
			return true;
		} else {
			return false;
		}
		// TODO Auto-generated method stub
		//return false;
	}

}
