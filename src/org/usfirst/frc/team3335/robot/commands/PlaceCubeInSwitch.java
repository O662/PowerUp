package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceCubeInSwitch extends CommandGroup {


	public PlaceCubeInSwitch(double intakeTime) throws InterruptedException  {
		double armSpeed = .3;
		addSequential(new Hand(false));
		Thread.sleep(750);
		addSequential(new ArmMoveToPosition(70,-armSpeed), 2);
		//addSequential(new Hand(true));
		addSequential(new IntakeCube(-1,true), intakeTime);
		addSequential(new Hand(true));
		//Thread.sleep(500);
		//addSequential(new IntakeCube(-1,false));
		addSequential(new ArmMoveBack(150,armSpeed), 2);
		
		
	}

}
