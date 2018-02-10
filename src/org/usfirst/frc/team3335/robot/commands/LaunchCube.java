package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LaunchCube extends Command {

	private final boolean turn;

	public LaunchCube(boolean turn) {
		super();
		requires(Robot.launcher);
		this.turn = turn;
	}

	@Override
	protected void execute() {
		if (turn) {
			Robot.launcher.turn();
		} else {
			Robot.launcher.stop();
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		//Robot.launcher.stop();
	}
}
