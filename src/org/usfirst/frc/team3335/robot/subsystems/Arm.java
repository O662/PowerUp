package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem implements LoggableSubsystem, PIDSource {
	//this subsystem is for the arm mechenism for grabing cubes its current design employs two motors that
	//activate simultaniusly to bring the arm down 
	private WPI_TalonSRX motorRight, motorLeft;
	private Encoder leftEncoder, rightEncoder;
	double pulsesPerRevolution = 256;
	double encoderToShaftRatio = 3;
	double stage3Ratio = 50.0 / 34.0;
	//double distancePerPulse = Math.PI * wheelDiameter / (encoderToShaftRatio * pulsesPerRevolution);
	//distancePerPulse /= stage3Ratio;
	private PIDSourceType pidSourceType = PIDSourceType.kDisplacement;

	public Arm() {
		motorRight = new WPI_TalonSRX(RobotMap.ARM_RIGHT_MOTOR);
		motorRight.setInverted(true);
		motorLeft = new WPI_TalonSRX(RobotMap.ARM_LEFT_MOTOR); 
		leftEncoder = new Encoder(RobotMap.ARM_ENCODER_LEFT_A, RobotMap.ARM_ENCODER_LEFT_B,
				RobotMap.ARM_ENCODER_LEFT_REVERSE, EncodingType.k4X);
		leftEncoder.reset();
		rightEncoder = new Encoder(RobotMap.ARM_ENCODER_RIGHT_A, RobotMap.ARM_ENCODER_RIGHT_B,
				RobotMap.ARM_ENCODER_RIGHT_REVERSE, EncodingType.k4X);
		rightEncoder.reset();
	}

	public void moveArm(double speed) {
		motorRight.set(speed);
		motorLeft.set(speed);
	}

	public void stop() {
		motorRight.set(0);
		motorLeft.set(0);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		pidSourceType = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return pidSourceType;
	}

	@Override
	public double pidGet() {
		//return centerX;
		//return targetOffsetX;
		return leftEncoder.getDistance();
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void log() {
		//motorRight.set(ControlMode.Position, value);
    	//SmartDashboard.putNumber("Arm: distance", getDistance());
    	SmartDashboard.putNumber("Arm: right distance", rightEncoder.getDistance());
    	//SmartDashboard.putNumber("Arm: right velocity", rightEncoder.getRate());
    	SmartDashboard.putNumber("Arm: left distance", leftEncoder.getDistance());
    	//SmartDashboard.putNumber("Arm: left velocity", leftEncoder.getRate());
    	SmartDashboard.putNumber("Arm: right motor current", motorRight.getOutputCurrent());
    	SmartDashboard.putNumber("Arm: left motor current", motorLeft.getOutputCurrent());
	}
}
