package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class HandToggle extends Command{

	public HandToggle() {
		requires(Robot.glove);
	}
	
	/*
	public Value getOpenClose() {
		Value val = Robot.glove.getValue();
		return val;
	}
	*/

	@Override
	protected void initialize() {
		Robot.glove.toggle();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
