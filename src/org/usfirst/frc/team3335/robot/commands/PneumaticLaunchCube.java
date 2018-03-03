package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PneumaticLaunchCube extends CommandGroup {

	public PneumaticLaunchCube() {
		addSequential(new ExtendCubeLauncher());
		addSequential(new Delay(1000));
		addSequential(new RetractCubeLauncher());
	}

}
