package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.PlaceCubeInSwitch;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideMiddle extends CommandGroup {
	
	//avoid going to color of our side and go to opposite side to cross line
	
	public AutoDecideMiddle() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null || gameData.isEmpty() || gameData.length() < 3) {
			return;
		}
		char ourSwitch = gameData.charAt(0);
		//char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);
		double armSpeed = .3;
		addSequential(new ArmMove(-armSpeed),2);
		addSequential(new ArmMoveBack(150,armSpeed),2);
		
		//crossing autoline command
		if(ourSwitch == 'L') {
		//goes to the left
		addSequential(new AutoDriveTurnToScale(-20,.5));
		addSequential(new AutoDriveStraight(90,.5,true,30,.25));
		addSequential(new AutoDriveTurnToScale(20,.3));
		addSequential(new AutoDriveStraight(12,.3), 2);
		addSequential(new PlaceCubeInSwitch());
		//addSequential(new Hand(true));
		}
		else if(ourSwitch == 'R') {
		//goes to the Right
		addSequential(new AutoDriveTurnToScale(20,.5));
		addSequential(new AutoDriveStraight(90,.5,true,30,.25));
		addSequential(new AutoDriveTurnToScale(-20,.3));
		addSequential(new AutoDriveStraight(12,.3), 2);
		addSequential(new PlaceCubeInSwitch());
		//addSequential(new Hand(true));
		}
	}

}
