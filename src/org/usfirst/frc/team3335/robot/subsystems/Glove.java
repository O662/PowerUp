package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Glove extends Subsystem implements LoggableSubsystem {
	//this is the grabber for the end of the arms and will employ two cylinders deploying at once
	private final DoubleSolenoid solenoid1;
	//private DoubleSolenoid solenoid2;

	public Glove() {
		solenoid1 = new DoubleSolenoid(RobotMap.GLOVE_PCM_MODULE, RobotMap.GLOVE_FORWARD_CHANNEL, RobotMap.GLOVE_REVERSE_CHANNEL);
		//solenoid2 = new DoubleSolenoid(RobotMap.GLOVE_FORWARD_CHANNEL_2, RobotMap.GLOVE_REVERSE_CHANNEL_2);
		open();
	}

	protected void switchPos(Value val) {
		solenoid1.set(val);
		//solenoid2.set(val);
	}

	public void open() {
		switchPos(Value.kReverse);
	}

	public void close() {
		switchPos(Value.kForward);
	}
	
	public Value getValue() {
		Value v = solenoid1.get();
		return v;
	}

	public void toggle() {
		Value val = solenoid1.get().equals(Value.kForward) ? Value.kReverse : Value.kForward;
		solenoid1.set(val);
	}

	@Override
	protected void initDefaultCommand() {

	}

	@Override
	public void log() {
	}
}
