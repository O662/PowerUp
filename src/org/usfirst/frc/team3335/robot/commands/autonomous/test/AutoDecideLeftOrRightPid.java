package org.usfirst.frc.team3335.robot.commands.autonomous.test;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.ArmMoveToPosition;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.LaunchCubeSmall;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallLaunchCube;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallestLaunchCube;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveStraight;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveStraightNavxPID;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveToSwitch;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveTurnToScale;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

//Deprecated due to warning below
@Deprecated
public class AutoDecideLeftOrRightPid extends CommandGroup {

	/*
	 * TODO: WARNING - this command group will not function as expected, due to
	 * getting the ultrasonic distance at the time the command is constructed,
	 * not at the time the command is started (running).
	 */

	/**
	 * Auto decide left or right
	 * @param leftOrRight L for left side, R for right side; unknown character goes to right side
	 */
	public AutoDecideLeftOrRightPid(char leftOrRight) {
		this("AutoTestPid", leftOrRight);
	}

	/**
	 * Auto decide left or right
	 * @param name for this command group
	 * @param leftOrRight L for left side, R for right side; unknown character goes to right side
	 */
	public AutoDecideLeftOrRightPid(String name, char leftOrRight) {
		super(name);
		requires(Robot.navx);
		requires(Robot.doubleUltrasonic);

		double armSpeed = 0.3;
		char ourSide = 'R';
		double turnAngle = 75;
		double setPointAngle = 90;
		if (leftOrRight == 'L' || leftOrRight == 'l') {
			ourSide = 'L';
			turnAngle = 75;
			setPointAngle = 90;
		} else {
			ourSide = 'R';
			turnAngle = -75;
			setPointAngle = -90;
		}
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null || gameData.isEmpty() || gameData.length() < 3) {
			return;
		}
		char ourSwitch = gameData.charAt(0);
		//char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);

		if (ourSwitch == ourSide) {
			//robot goes to switch and places cube
			//if strait on
			//addSequential(new AutoDriveStraightPlaceCube());

			//if not straight on
			addSequential(new ArmMove(-armSpeed), 2);
			addSequential(new ArmMoveBack(150,armSpeed), 2);
			addSequential(new AutoDriveStraightNavxPID(148, 0.5, true, 30, 0.25));
			addSequential(new AutoDriveTurnToScale(turnAngle, 0.5));

			// After turning, drive to switch
			double distance = Robot.doubleUltrasonic.getDistanceFront() - 10;
			addSequential(new AutoDriveAtAngleNavxPID(distance, 0.3, setPointAngle));

			addSequential(new LaunchCubeSmall());
		} else {
			//robot drives across autoline
			addSequential(new ArmMove(-armSpeed), 2);
			addSequential(new ArmMoveBack(150, armSpeed), 2);
			addSequential(new AutoDriveStraightNavxPID(110, 0.5));
		}
	}
}
