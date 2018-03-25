package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.subsystems.DoubleUltrasonic;

import edu.wpi.first.wpilibj.command.Command;

//Deprecated due to warning below
@Deprecated
public class AutoWillWeTurn extends Command {

	public boolean willTurn = false;
	public double differnce;
	public boolean isRight; //if right distance is greater than this will be true
	
	/**
	 * TODO: WARNING - this command group will not function as expected, due to
	 * getting the ultrasonic distance at the time the command is constructed,
	 * not at the time the command is started (running).
	 */
	public AutoWillWeTurn() {
	requires(Robot.doubleUltrasonic);
	
	
	
	}
	
	public AutoWillWeTurn(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public AutoWillWeTurn(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public AutoWillWeTurn(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}
	public void getStraight() {
	double distanceLeft = Robot.doubleUltrasonic.getDistanceLeft();
	double distanceRight = Robot.doubleUltrasonic.getDistanceRight();
	
	
	
	if(distanceLeft == 6 && distanceRight == 6) {
		
	}
	else if(distanceLeft != distanceRight){
		
		willTurn = true;
		if(distanceLeft > distanceRight) {
			isRight = false;
		}
		else {
			isRight = true;
		}
		differnce = Math.abs(distanceLeft-distanceRight);
		
	}
	
	}
	public boolean Turn() {
		return willTurn;
	}
	public boolean Side() {
		return isRight;
	}
	public double Distance() {
		return differnce;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
