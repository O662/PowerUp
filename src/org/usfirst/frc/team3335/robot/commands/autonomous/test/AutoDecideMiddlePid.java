package org.usfirst.frc.team3335.robot.commands.autonomous.test;

import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.ArmMoveToPosition;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.LaunchCubeSmall;
import org.usfirst.frc.team3335.robot.commands.PlaceCubeInSwitch;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallestLaunchCube;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveStraight;
import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDriveTurnToScale;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideMiddlePid extends CommandGroup {

	// Avoid going to color of our side and go to opposite side to cross line
	public AutoDecideMiddlePid() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null || gameData.isEmpty() || gameData.length() < 3) {
			return;
		}
		char ourSwitch = gameData.charAt(0);
		//char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);

		double armSpeed = 0.3;
		addSequential(new ArmMove(-armSpeed), 2);
		addSequential(new ArmMoveBack(150, armSpeed), 2);

		// Crossing autoline command
		double distance = 90;
		double setPointAngle = 20;
		if (ourSwitch == 'L') {
			// Goes to the right
			addSequential(new AutoDriveAtAngleNavxPID(distance, 0.5, true, 30, 0.25, -setPointAngle));
			addSequential(new AutoDriveTurnToScale(20, 0.3));
		} else if (ourSwitch == 'R') {
			// Goes to the left
			addSequential(new AutoDriveAtAngleNavxPID(distance, 0.5, true, 30, 0.25, setPointAngle));
			addSequential(new AutoDriveTurnToScale(-20, 0.3));
		} else {
			return;
		}
		addSequential(new AutoDriveStraight(12, 0.3), 2);
		//addSequential(new PlaceCubeInSwitch());
		addSequential(new LaunchCubeSmall());
	}
}
