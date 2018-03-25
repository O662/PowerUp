package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.commands.autonomous.test.AutoDriveAtAngleNavxPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

//Deprecated due to warning below
@Deprecated
public class AutoDriveToSwitchVision extends CommandGroup {
	
	/**
	 * TODO: WARNING - this command group will not function as expected, due to
	 * getting the vision target info at the time the command
	 * is constructed, not at the time the command is started (running).
	 */
	public AutoDriveToSwitchVision() {
		
		requires(Robot.visionTarget);
		
		double setPointAngle = 90;
		addSequential(new AutoFindVisionTarget(.3,.3));
		double distance = Robot.visionTarget.getTargetDistance();
		addSequential(new AutoDriveAtAngleNavxPID(distance,.3,setPointAngle));
		
		
		
	}

}
