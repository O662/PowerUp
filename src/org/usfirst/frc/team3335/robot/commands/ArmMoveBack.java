package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmMoveBack extends Command {

	private final double speed;
	private final double distance;


	
	public ArmMoveBack(double distance, double speed) {
		this.speed = speed;
		this.distance = distance;
	}

	@Override
	protected void execute() {
		Robot.arm.moveArm(speed);
	}

	@Override
	protected boolean isFinished() {
		if(Robot.arm.getRightPosition() > distance) {
			return true;
		}
		if (speed < 0) {
			return Robot.arm.isSwitchClosed();
		}
		return false;
	}

	@Override
	protected void end() {
		Robot.arm.stop();
	}
}
