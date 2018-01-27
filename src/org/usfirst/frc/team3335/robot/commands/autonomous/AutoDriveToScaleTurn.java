package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.BallShiftLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveToScaleTurn extends CommandGroup {
	
	public AutoDriveToScaleTurn(int Angle) {
		
		addSequential(new AutoDriveStraight(324,0.7));
		
		addSequential(new AutoDriveTurnToScale(Angle,0.7));
		
	}
	
	
	

	@Override
	protected boolean isFinished() {
	
		// TODO Auto-generated method stub
		return false;
	}

}
