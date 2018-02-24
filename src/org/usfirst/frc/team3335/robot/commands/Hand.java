package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Hand extends Command {

	private final boolean open;

	/**
	 * constructor
	 * @param open true = hands open, false = hands close
	 */
	public Hand(boolean open) {
		requires(Robot.glove);
		this.open = open;
	}

	@Override
	protected void initialize() {
		if (open) {
			Robot.glove.open();
		} else {
			Robot.glove.close();
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
