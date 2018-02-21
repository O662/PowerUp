package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.Hand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDumpCube extends CommandGroup {
	
	public AutoDumpCube() {
		addSequential(new Hand(true));
		
	}
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
