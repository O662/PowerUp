package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.commands.Hand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideMiddle extends CommandGroup {
	
	//avoid going to color of our side and go to opposite side to cross line
	
	public AutoDecideMiddle() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		char ourSwitch = gameData.charAt(0);
		char Scale = gameData.charAt(1);
		char theirSwitch = gameData.charAt(2);
		
		
		//crossing autoline command
		if(ourSwitch == 'L') {
		//goes to the right
		addSequential(new AutoDriveTurnToScale(20,.5));
		addSequential(new AutoDriveStraight(85,.3));
		//addSequential(new Hand(true));
		}
		else if(ourSwitch == 'R') {
		//goes to the left
		addSequential(new AutoDriveTurnToScale(-20,.5));
		addSequential(new AutoDriveStraight(85,.3));
		//addSequential(new Hand(true));
		}
	}

}
