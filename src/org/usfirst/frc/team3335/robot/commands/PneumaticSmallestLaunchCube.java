package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PneumaticSmallestLaunchCube extends CommandGroup {

	public PneumaticSmallestLaunchCube() {
		addSequential(new ExtendCubeLauncherSmall());
		addSequential(new Delay(1000));
		addSequential(new RetractCubeLauncher());
	}

	

}
