package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Launcher extends Subsystem implements LoggableSubsystem {
	//this subsystem at the moment employs a motor to lower the launcher over a spring but is subject to change
	private final WPI_TalonSRX launcherMotorRight;
	private final WPI_TalonSRX launcherMotorLeft;
	//private final Encoder launcherEncoder;
	//private final double pulsesPerRevolution = 256;
	//private final double encoderToShaftRatio = 3;
	//private final double stage3Ratio = 50.0 / 34.0;

	public Launcher() {
		launcherMotorRight = new WPI_TalonSRX(RobotMap.LAUNCHER_RIGHT_MOTOR);
		launcherMotorLeft = new WPI_TalonSRX(RobotMap.LAUNCHER_LEFT_MOTOR);
		//launcherEncoder = new Encoder(RobotMap.LAUNCHER_ENCODER_A, RobotMap.LAUNCHER_ENCODER_B,
		//		RobotMap.LAUNCHER_ENCODER_REVERSE, EncodingType.k4X);
		launcherMotorRight.setNeutralMode(NeutralMode.Coast/*Brake*/);
		launcherMotorLeft.setNeutralMode(NeutralMode.Coast/*Brake*/);

		// Motors turn in opposite direction.  Must flip polarity of one.
		launcherMotorLeft.setInverted(true); // Mark 3 = true
	}

	public void initDefaultCommand() {
	}

	public void turn(boolean forward) {
		double voltage = forward ? 1 : -1;
		launcherMotorRight.set(voltage);
		launcherMotorLeft.set(voltage);
	}

	public void stop() {
		launcherMotorRight.set(0);
		launcherMotorLeft.set(0);
	}

	@Override
	public void log() {
		SmartDashboard.putNumber("Launcher: right current", launcherMotorRight.getOutputCurrent());
		SmartDashboard.putNumber("Launcher: right current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_LAUNCHER_RIGHT));
		SmartDashboard.putNumber("Launcher: left current", launcherMotorLeft.getOutputCurrent());
		SmartDashboard.putNumber("Launcher: left current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_LAUNCHER_LEFT));
	}
}
