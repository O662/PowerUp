package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BallShiftHigh extends Command {

	public BallShiftHigh() {
		requires(Robot.ballShifter);
	}

	@Override
	protected void initialize() {
		Robot.ballShifter.shiftHigh();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
