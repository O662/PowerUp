package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BallShiftLow extends Command {

	public BallShiftLow() {
		requires(Robot.ballShifter);
	}

	@Override
	protected void initialize() {
		Robot.ballShifter.shiftLow();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
