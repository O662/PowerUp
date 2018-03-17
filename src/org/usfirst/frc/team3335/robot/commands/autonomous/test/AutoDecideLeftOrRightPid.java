package org.usfirst.frc.team3335.robot.commands.autonomous.test;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.commands.ArmMoveToPosition;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallLaunchCube;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveStraightNavxPID;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveTurnToScale;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideLeftOrRightPid extends CommandGroup {

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

		char ourSide = 'R';
		double turnAngle = 80;
		double setPointAngle = 90;
		if (leftOrRight == 'L' || leftOrRight == 'l') {
			ourSide = 'L';
			turnAngle = 80;
			setPointAngle = 90;
		} else {
			ourSide = 'R';
			turnAngle = -80;
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
			addSequential(new AutoDriveStraightNavxPID(/*153*/144, 0.3));
			addSequential(new AutoDriveTurnToScale(turnAngle, 0.5));

			// After turning, drive to switch
			double distance = Robot.doubleUltrasonic.getDistanceLeft() - 10;
			addSequential(new AutoDriveAtAngleNavxPID(distance, 0.3, setPointAngle));

			addSequential(new Hand(true));
			addSequential(new ArmMoveToPosition(70, -0.2));
			addSequential(new PneumaticSmallLaunchCube());
		} else {
			//robot drives across autoline
			addSequential(new AutoDriveStraightNavxPID(80, 0.3));
		}
	}
}
