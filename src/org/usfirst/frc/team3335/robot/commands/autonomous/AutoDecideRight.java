package org.usfirst.frc.team3335.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideRight extends CommandGroup {
	
	public AutoDecideRight() {
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		char ourSwitch = gameData.charAt(0);
		char Scale = gameData.charAt(1);
		char theirSwitch = gameData.charAt(2);
		if(ourSwitch == 'R')
		{
			//Autonomus to drive strait and place cube in switch
		} 
		else if(Scale == 'R') { 
			//robot drives to and turns to scale
			addSequential(new AutoDriveToScaleTurn(90));
		}
		else {
			//robot drives across autoline
			addSequential(new AutoDriveStraight(140,.7));
		}
		
		
		
		
	}

}
