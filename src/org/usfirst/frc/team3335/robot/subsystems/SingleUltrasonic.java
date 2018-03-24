package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;
import org.usfirst.frc.team3335.robot.RobotPreferences;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SingleUltrasonic extends Subsystem implements LoggableSubsystem{
	// TODO set voltageToInches correctly for ultrasonics
	private static final double kVoltageToInches = 40.2969;
	private final AnalogInput ultrasonicFront;

	public SingleUltrasonic() {
		ultrasonicFront = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_FRONT);
	}

	public double getDistance() {
		return getDistance(ultrasonicFront);
	}

	private double getDistance(AnalogInput ultrasonic) {
		return ultrasonic.getAverageVoltage()*kVoltageToInches;
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void log() {
		//SmartDashboard.putNumber("UltraSonic front distance", getDistance());
	}

}
