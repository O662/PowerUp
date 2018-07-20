package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.Delay;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.LaunchCubeSmall;
import org.usfirst.frc.team3335.robot.commands.PlaceCubeInSwitch;
import org.usfirst.frc.team3335.robot.commands.autonomous.test.AutoDriveAtAngleNavxPID;
import org.usfirst.frc.team3335.robot.subsystems.vision.VisionTarget;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

//Deprecated due to warning below
//@Deprecated
/*
public class AutoDecideMiddleVision extends CommandGroup {
	
	/**
	 * TODO: WARNING - this command group will not function as expected, due to
	 * getting the vision target info and the navx yaw angle at the time the command
	 * is constructed, not at the time the command is started (running).
	 * @throws InterruptedException 
	 */
/*
	public AutoDecideMiddleVision() throws InterruptedException {
		requires(Robot.visionTarget);
		requires(Robot.navx);

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

		//crossing autoline command
		double distance = 75; // 90;
		double angle = 20;
		if (ourSwitch == 'L') {
			//goes to the left
			addSequential(new AutoDriveTurnToScale(-angle, 0.5));
			addSequential(new AutoDriveStraight(distance, 0.5, true, 30, 0.25));
			addSequential(new AutoDriveTurnToScale(angle, 0.3));
		} else if(ourSwitch == 'R') {
			//goes to the Right
			addSequential(new AutoDriveTurnToScale(angle, 0.5));
			addSequential(new AutoDriveStraight(78, 0.5, true, 30, 0.25));
			addSequential(new AutoDriveTurnToScale(-24, 0.3));
		} else {
			return;
		}
		/*
		addSequential(new Delay(500, true));
		if (Robot.visionTarget.isTargetDetected()) {
			double targetDist = VisionTarget.getTargetDistance();
			double setPointAngle = VisionTarget.pidGet();
			setPointAngle += Robot.navx.getYaw();
			addSequential(new AutoDriveAtAngleNavxPID(targetDist, 0.5, true, 30, 0.25, setPointAngle), 5);
			addSequential(new PlaceCubeInSwitch(3));
			//addSequential(new LaunchCubeSmall());
			 * 
			 
			 
		} else {
			addSequential(new AutoDriveStraight(44, 0.3), 2);
			addSequential(new PlaceCubeInSwitch(3));
		}
	}

}
*/
