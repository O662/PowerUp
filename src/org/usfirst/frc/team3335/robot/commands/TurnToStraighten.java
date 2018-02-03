package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToStraighten extends Command {
	
	double speed;
	double distance;
	boolean isRight;
	public TurnToStraighten(double distance, boolean isRight, double speed) {
		
		requires(Robot.driveTrain);
		this.distance = distance;
		this.isRight = isRight;
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	protected void initialize() {
		Robot.driveTrain.setBrake(true);
		Robot.driveTrain.zeroEncoders();
	}
	
	public void Turn() {
		if(isRight) {
			Robot.driveTrain.drive(0, speed);
		}
		else {
			Robot.driveTrain.drive(speed, 0);
		}
		
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
