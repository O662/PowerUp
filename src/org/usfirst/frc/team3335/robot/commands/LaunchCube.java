package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LaunchCube extends Command {

	private final boolean turn;

	private final boolean reverse;

	public LaunchCube(boolean turn) {
		this(turn, false);
	}

	public LaunchCube(boolean turn, boolean reverse) {
		super();
		requires(Robot.launcher);
		this.turn = turn;
		this.reverse = reverse;
	}

	@Override
	protected void execute() {
		if (turn) {
			Robot.launcher.turn(reverse);
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
