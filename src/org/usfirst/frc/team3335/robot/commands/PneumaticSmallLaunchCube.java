package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PneumaticSmallLaunchCube extends CommandGroup {
	public PneumaticSmallLaunchCube() {
		addSequential(new ExtendCubeLauncher(true));
		addSequential(new Delay(1000));
		addSequential(new RetractCubeLauncher());
	}

}
