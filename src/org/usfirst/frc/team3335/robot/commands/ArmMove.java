package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmMove extends Command {

	private final double speed;

	public ArmMove(double speed) {
		super();
		requires(Robot.arm);
		this.speed = speed;
	}

	@Override
	protected void execute() {
		Robot.arm.moveArm(speed);
	}

	@Override
	protected boolean isFinished() {
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
