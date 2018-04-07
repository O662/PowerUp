package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.ArmMoveToPosition;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.LaunchCubeSmall;
import org.usfirst.frc.team3335.robot.commands.PlaceCubeInSwitch;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallestLaunchCube;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideMiddle extends CommandGroup {
	
	//avoid going to color of our side and go to opposite side to cross line
	
	public AutoDecideMiddle() throws InterruptedException {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null || gameData.isEmpty() || gameData.length() < 3) {
			return;
		}
		char ourSwitch = gameData.charAt(0);
		//char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);
		double armSpeed = 0.3;
		addSequential(new ArmMove(-armSpeed), 2);
		addSequential(new ArmMoveBack(150, armSpeed), 2);
		addSequential(new Hand(true));
		
		//the middle will be slightly shifted to the right
		//crossing autoline command
		
		if (ourSwitch == 'L') {
			//goes to the left
			Robot.navx.zeroYaw();
			
			addSequential(new AutoDriveTurnToScale(-20, .3));
			
			
			if(Robot.navx.getYaw() > -1 && Robot.navx.getYaw() < 1) {
				DriverStation.reportWarning("Robot Did not turn",true);
			}
			
			addSequential(new AutoDriveStraight(80, 0.7, true, 30, .3));
			addSequential(new AutoDriveTurnToScale(32, 0.3));
		} else if(ourSwitch == 'R') {
			//goes to the Right
			//values do not need to be changed with this if testing anything make new test lines;
			addSequential(new AutoDriveTurnToScale(18, 0.5));
			addSequential(new AutoDriveStraight(74, 0.7, true, 30, .3));
			addSequential(new AutoDriveTurnToScale(-30, 0.3));
			
			//testing values for left
			Robot.navx.zeroYaw();
			//addSequential(new AutoDriveTurnToScale(20, .5));
			//addSequential(new AutoDriveStraight(80, 0.7, true, 30, .3));
			//addSequential(new AutoDriveTurnToScale(-36, 0.3));
		} else {
			return;
		}
		//addSequential(new AutoDriveStraight(62, 0.4), 2);
		//addSequential(new PlaceCubeInSwitch(4));
		//addSequential(new LaunchCubeSmall());
	}

}
