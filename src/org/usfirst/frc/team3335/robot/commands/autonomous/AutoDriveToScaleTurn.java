package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.commands.BallShiftLow;
import org.usfirst.frc.team3335.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveToScaleTurn extends CommandGroup {

	public AutoDriveToScaleTurn(double setPointAngle) {
		this(324, 0.7, setPointAngle, 0.4);
	}

	public AutoDriveToScaleTurn(double distance, double driveSpeed, double setPointAngle, double turnSpeed) {
		//addSequential(new AutoDriveStraight(324,0.7));
		//addSequential(new AutoDriveTurnToScale(setPointAngle,0.7));
		//addSequential(new AutoBackToWall());
		addSequential(new AutoDriveStraightNavxPID(distance, driveSpeed));
		addSequential(new Delay(500, true));
		addSequential(new AutoDriveTurnToScale(setPointAngle, turnSpeed));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
