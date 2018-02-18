package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class Hand extends Command {

	private DoubleSolenoid.Value val;

	/**
	 * constructor
	 * @param open true = hands open, false = hands close
	 */
	public Hand(boolean open) {
		requires(Robot.glove);
		val = open ? Value.kReverse : Value.kForward;
	}

	@Override
	protected void initialize() {
		Robot.glove.switchPos(val);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
