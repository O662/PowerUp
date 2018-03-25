package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.commands.BackUpToWall;
import org.usfirst.frc.team3335.robot.commands.TurnToStraighten;

import edu.wpi.first.wpilibj.command.CommandGroup;

//Deprecated due to warning below
@Deprecated
public class AutoBackToWall extends CommandGroup {

	boolean isRight, willTurn;
	double differnce;
	double timeFinished = 5000;//milliseconds

	/**
	 * TODO: WARNING - this command group will not function as expected, due to
	 * getting the ultrasonic distance at the time the command is constructed,
	 * not at the time the command is started (running).
	 */
	public AutoBackToWall() {
		this("AutoBackToWall");
	}

	public AutoBackToWall(String name) {
		super(name);
		requires(Robot.driveTrain);
		requires(Robot.doubleUltrasonic);
		
		if (getStraight() > 0) {
			willTurn = false;
		} else {
			willTurn = true;
		}
		if (willTurn) {
			addSequential(new TurnToStraighten(Math.abs(getStraight()), willTurn, .7));
		}
		addSequential(new BackUpToWall(.7));
	}

	public double getStraight() {
		double distanceLeft = Robot.doubleUltrasonic.getDistanceLeft();
		double distanceRight = Robot.doubleUltrasonic.getDistanceRight();

		if (distanceLeft == 6 && distanceRight == 6) {
			
		} else if (distanceLeft != distanceRight) {
			willTurn = true;
			if (distanceLeft > distanceRight) {
				isRight = false;
			} else {
				isRight = true;
			}
			differnce = distanceLeft-distanceRight;
			if (differnce <= 2) {
				willTurn = false;
			} else {
				willTurn = true;
			}
		}
		return differnce;
	}
	
	@Override
	protected boolean isFinished() {
		if (System.currentTimeMillis() > timeFinished) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrain.drive(0, 0);
		Robot.driveTrain.setBrake(false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
