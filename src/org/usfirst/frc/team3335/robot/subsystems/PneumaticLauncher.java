package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticLauncher extends Subsystem implements LoggableSubsystem{

	private final DoubleSolenoid solenoid1;
	private final DoubleSolenoid solenoid2;
	private final DoubleSolenoid solenoid3;

	public PneumaticLauncher() {
		solenoid1 = new DoubleSolenoid(RobotMap.LAUNCHER_PCM_MODULE, RobotMap.LAUNCHER_LEFT_FORWARD_CHANNEL, RobotMap.LAUNCHER_LEFT_REVERSE_CHANNEL);
		solenoid2 = new DoubleSolenoid(RobotMap.LAUNCHER_PCM_MODULE, RobotMap.LAUNCHER_CENTER_FORWARD_CHANNEL, RobotMap.LAUNCHER_CENTER_REVERSE_CHANNEL);
		solenoid3 = new DoubleSolenoid(RobotMap.LAUNCHER_PCM_MODULE, RobotMap.LAUNCHER_RIGHT_FORWARD_CHANNEL, RobotMap.LAUNCHER_RIGHT_REVERSE_CHANNEL);
		close();
	}

	public void open(boolean small) {
		if (small) {
			solenoid2.set(Value.kForward);
			solenoid1.set(Value.kForward);
		}
		else {
			solenoid1.set(Value.kForward);
			solenoid2.set(Value.kForward);
		solenoid3.set(Value.kForward);
		}
		
	}
	public void open2() {
		solenoid2.set(Value.kForward);
	}

	public void close() {
		solenoid1.set(Value.kReverse);
		solenoid2.set(Value.kReverse);
		solenoid3.set(Value.kReverse);
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
