package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceCubeInSwitch extends CommandGroup {

	public PlaceCubeInSwitch() {
		this("PlaceCubeInSwitch");
	}

	public PlaceCubeInSwitch(String name) {
		super(name);
		double armSpeed = .3;
		addSequential(new Hand(false));
		addSequential(new ArmMoveToPosition(70,-armSpeed), 2);
		addSequential(new Hand(true));
		addSequential(new ArmMoveBack(150,armSpeed), 2);
		
		
	}

}
