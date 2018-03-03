package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem implements LoggableSubsystem {

	public Vision() {
		//Relay relay = new Relay(RobotMap.RELAY_CHANNEL,Direction.kForward);
		//relay.set(Relay.Value.kOn);
		Solenoid solenoid = new Solenoid(RobotMap.LIGHT_RING_PCM_MODULE, RobotMap.LIGHT_RING_CHANNEL);
		solenoid.set(true);
	}

	@Override
	public void log() {
	}

	@Override
	protected void initDefaultCommand() {
	}

}
