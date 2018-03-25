package org.usfirst.frc.team3335.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3335.robot.Robot;

public class ArmWithJoystick extends Command{

	public  ArmWithJoystick() {
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Robot.arm.setBrake(false);
		//Robot.arm.setDefaltRampRate();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.arm.moveArm(Robot.oi.getJoystick2());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.arm.moveArm(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
