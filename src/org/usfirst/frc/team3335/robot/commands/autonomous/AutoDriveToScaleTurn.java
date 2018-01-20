package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.BallShiftLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveToScaleTurn extends CommandGroup {
	
	public AutoDriveToScaleTurn() {
		
		addSequential(new AutoDriveStraight(324,70));
		
		addSequential(new AutoDriveTurnToScale(90,70));
		
	}
	
	
	

	@Override
	protected boolean isFinished() {
	
		// TODO Auto-generated method stub
		return false;
	}

}
