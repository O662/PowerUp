package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.ArmMoveToPosition;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.PneumaticLaunchCube;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallLaunchCube;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallestLaunchCube;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideRight extends CommandGroup {
	
	public AutoDecideRight() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null  || gameData.isEmpty() || gameData.length() < 3) {
			return;
		}
		char ourSwitch = gameData.charAt(0);
		//char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);
		
		
		
		if(ourSwitch == 'R')
		{
			//robot goes to switch and places cube
			//if strait on
			//addSequential(new AutoDriveStraightPlaceCube());
			
			//if not straight on 
			addSequential(new ArmMove(-.2),2);
			addSequential(new ArmMoveBack(150,.2),2);
			addSequential(new AutoDriveStraight(153,.3));
			addSequential(new AutoDriveTurnToScale(-80,.5));
			addSequential(new AutoDriveToSwitch());
			addSequential(new Hand(true));
			addSequential(new ArmMoveToPosition(70,-.2));
			addSequential(new PneumaticSmallestLaunchCube());
			
		} 
		
		
		
		
		
		/*
		if(Scale == 'R') { 
			//robot drives to and turns to scale
			addSequential(new AutoDriveToScaleTurn(90));
			addSequential(new PneumaticLaunchCube());
		}
		*/
		else {
			//robot drives across autoline
			addSequential(new ArmMove(-.2),2);
			addSequential(new ArmMoveBack(150,.2),2);
			addSequential(new AutoDriveStraight(110,.3));
		}
		
		
		
		
	}

}
