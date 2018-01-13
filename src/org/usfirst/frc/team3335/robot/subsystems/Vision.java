package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem implements LoggableSubsystem {

	public Vision() {
		Relay relay = new Relay(RobotMap.RELAY_CHANNEL,Direction.kForward);
		relay.set(Relay.Value.kOn);
	}
	@Override
	public void log() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
