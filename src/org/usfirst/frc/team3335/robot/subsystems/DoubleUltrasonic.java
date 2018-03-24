package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;
import org.usfirst.frc.team3335.robot.RobotPreferences;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DoubleUltrasonic extends Subsystem implements LoggableSubsystem{
	// TODO set voltageToInches correctly for ultrasonics
	private static final double kVoltageToInches = 40.2969;
	private final AnalogInput ultrasonicLeft;
	private final AnalogInput ultrasonicRight;
	private final AnalogInput ultrasonicFront;

	public DoubleUltrasonic() {
		ultrasonicLeft = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_BACK_LEFT);
		ultrasonicRight = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_BACK_RIGHT);
		ultrasonicFront = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_FRONT);
		
		
	}
;
	public double getDistanceLeft() {
		return getDistance(ultrasonicLeft);
	}

	public double getDistanceRight() {
		return getDistance(ultrasonicRight);
	}
	
	public double getDistanceFront() {
		return getDistance(ultrasonicFront);
	}

	public double getDistance() {
		return 0.5*(getDistanceLeft()+getDistanceRight());
	}

	private double getDistance(AnalogInput ultrasonic) {
		return ultrasonic.getAverageVoltage()*kVoltageToInches;
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void log() {
		SmartDashboard.putNumber("UltraSonic Right distance", getDistanceRight());
		SmartDashboard.putNumber("UltraSonic Left distance", getDistanceLeft());
		SmartDashboard.putNumber("Ultrasonic Front distance", getDistanceFront());
		SmartDashboard.putNumber("UltraSonic combined distance", getDistance());
		
		
	}

}
