package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LauncherPneumatics extends Subsystem {

	private DoubleSolenoid solenoidLeft, solenoidCenter, solenoidRight;

	public LauncherPneumatics () {
		solenoidLeft = new DoubleSolenoid(RobotMap.LAUNCHER_PCM_MODULE, RobotMap.LAUNCHER_LEFT_FORWARD_CHANNEL, RobotMap.LAUNCHER_LEFT_REVERSE_CHANNEL);
		setSolenoidValue(DoubleSolenoid.Value.kOff);
		solenoidCenter = new DoubleSolenoid(RobotMap.LAUNCHER_PCM_MODULE, RobotMap.LAUNCHER_CENTER_FORWARD_CHANNEL, RobotMap.LAUNCHER_CENTER_REVERSE_CHANNEL);
		setSolenoidValue(DoubleSolenoid.Value.kOff);
		solenoidRight = new DoubleSolenoid(RobotMap.LAUNCHER_PCM_MODULE, RobotMap.LAUNCHER_RIGHT_FORWARD_CHANNEL, RobotMap.LAUNCHER_RIGHT_REVERSE_CHANNEL);
		setSolenoidValue(DoubleSolenoid.Value.kOff);
	}

	public void setSolenoidValue(DoubleSolenoid.Value value) {
		solenoidLeft.set(value);
		solenoidCenter.set(value);
		solenoidRight.set(value);
	}

	public DoubleSolenoid.Value getSolenoidValue() {
		return solenoidLeft.get();
	}

	public void turn(boolean reverse) {
		// TODO Auto-generated method stub
	}

	public void stop() {
		// TODO Auto-generated method stub
	}

	public void log() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

}
