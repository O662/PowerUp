package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RetractCubeLauncher extends Command{
	
	public RetractCubeLauncher() {
		requires(Robot.pneumaticLauncher);
		
	}
	
	@Override
	protected void initialize() {
		Robot.pneumaticLauncher.close();
	}
	

	@Override
	protected boolean isFinished() {
		return true;
	}

}
