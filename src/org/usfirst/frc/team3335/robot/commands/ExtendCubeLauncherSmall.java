package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExtendCubeLauncherSmall extends Command {


	public ExtendCubeLauncherSmall() {
		requires(Robot.pneumaticLauncher);
		
		
	}
	
	@Override
	protected void initialize() {
		Robot.pneumaticLauncher.open2();
	}


	@Override
	protected boolean isFinished() {
		return true;
	}

}
