package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExtendCubeLauncher extends Command {

	private boolean small;
	public ExtendCubeLauncher(boolean small) {
		requires(Robot.pneumaticLauncher);
		this.small = small;
		
	}
	
	@Override
	protected void initialize() {
		Robot.pneumaticLauncher.open(small);
	}


	@Override
	protected boolean isFinished() {
		return true;
	}

}
