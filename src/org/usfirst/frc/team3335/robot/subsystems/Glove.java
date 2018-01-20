package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Glove extends Subsystem implements LoggableSubsystem {
	//this is the grabber for the end of the arms and will employ two cylanders deploying at once
	private DoubleSolenoid solenoid;
	
	public Glove() {
		solenoid = new DoubleSolenoid(RobotMap.GLOVE_FORWARD_CHANNEL, RobotMap.GLOVE_REVERSE_CHANNEL);
		solenoid.set(Value.kReverse);
	}
	
    @Override
    protected void initDefaultCommand() {

    }

    @Override
    public void log() {

    }
}
