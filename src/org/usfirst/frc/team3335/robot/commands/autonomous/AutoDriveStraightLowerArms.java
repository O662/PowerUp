package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveStraightLowerArms extends CommandGroup {

	public AutoDriveStraightLowerArms() {
		addSequential(new ArmMove(-.2),2);
		addSequential(new ArmMoveBack(150,.2),2);
		addSequential(new AutoDriveStraight(110,.3));
	}

}
