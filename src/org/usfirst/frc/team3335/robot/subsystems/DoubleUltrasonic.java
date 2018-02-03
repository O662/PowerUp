package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DoubleUltrasonic extends Subsystem implements LoggableSubsystem{ 
	private static final double kVoltageToInches = 40.2969;
	
	private AnalogInput ultrasonicLeft = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_LEFT);
	private AnalogInput ultrasonicRight = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_RIGHT);
	public DoubleUltrasonic() {
		// TODO Auto-generated constructor stub
	}

	public DoubleUltrasonic(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public double getDistanceLeft() {
		return getDistance(ultrasonicLeft);
	}
	public double getDistanceRight() {
		return getDistance(ultrasonicRight);
	}
	public double getDistance() {
		return 0.5*(getDistanceLeft()*getDistanceRight());
	}
	private double getDistance(AnalogInput ultrasonic) {
		return ultrasonic.getAverageVoltage()*kVoltageToInches;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	@Override
	public void log() {
		// TODO Auto-generated method stub
		
	}

}
