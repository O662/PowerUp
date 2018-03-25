package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCube extends Command {
	
	private final double speed;
	private final boolean finished;

	public IntakeCube(double speed, boolean isFinished) {
		super();
		requires(Robot.armIntake);
		this.speed = speed;
		finished = isFinished;
	}

	@Override
	protected void execute() {
		Robot.armIntake.moveArm(speed);
	}

	@Override
	protected boolean isFinished() {
		if(!finished || Robot.armIntake.isCurrentExceeded()) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void end() {
		Robot.armIntake.stop();
	}

}
