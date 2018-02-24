package org.usfirst.frc.team3335.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3335.robot.RobotMap;

public class BallShifter extends Subsystem implements LoggableSubsystem{

	private final DoubleSolenoid solenoid;

	public BallShifter() {
		solenoid = new DoubleSolenoid(RobotMap.BALL_SHIFTER_FORWARD_CHANNEL, RobotMap.BALL_SHIFTER_REVERSE_CHANNEL);
		setSolenoidValue(DoubleSolenoid.Value.kOff);
	}

	public void setSolenoidValue(DoubleSolenoid.Value value) {
		solenoid.set(value);
	}

	public DoubleSolenoid.Value getSolenoidValue() {
		return solenoid.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void log() {
	}

}
