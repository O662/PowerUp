package org.usfirst.frc.team3335.robot.commands.autonomous.test;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideMiddlePid extends CommandGroup {

	// Avoid going to color of our side and go to opposite side to cross line
	public AutoDecideMiddlePid() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		char ourSwitch = gameData.charAt(0);
		//char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);

		// Crossing autoline command
		double distance = 85;
		double setPointAngle = 20;
		if (ourSwitch == 'L') {
			// Goes to the right
			addSequential(new AutoDriveAtAngleNavxPID(distance, 0.3, setPointAngle));
		} else {
			// ourSwitch == 'R'
			// Goes to the left
			addSequential(new AutoDriveAtAngleNavxPID(distance, 0.3, -setPointAngle));
		}
	}
}
