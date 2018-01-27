package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem implements LoggableSubsystem {
	//this subsystem is for the arm mechenism for grabing cubes its current design employs two motors that
	//activate simultaniusly to bring the arm down 
	private WPI_TalonSRX ArmMotor1, ArmMotor2;
	private Encoder leftEncoder, rightEncoder;
	double pulsesPerRevolution = 256;
	double encoderToShaftRatio = 3;
	double stage3Ratio = 50.0 / 34.0;
     //double distancePerPulse = Math.PI * wheelDiameter / (encoderToShaftRatio * pulsesPerRevolution);
     //distancePerPulse /= stage3Ratio;
	
	public Arm() {
		ArmMotor1 = new WPI_TalonSRX(RobotMap.ARM_MOTOR_1);
		ArmMotor2 = new WPI_TalonSRX(RobotMap.ARM_MOTOR_2); 
		leftEncoder = new Encoder(RobotMap.ARM_ENCODER_LEFT_A, RobotMap.ARM_ENCODER_LEFT_B,
        RobotMap.ARM_ENCODER_LEFT_REVERSE, EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.ARM_ENCODER_RIGHT_A, RobotMap.ARM_ENCODER_RIGHT_B,
        RobotMap.ARM_ENCODER_RIGHT_REVERSE, EncodingType.k4X);
		
	}
	
	public void LowerArm() {
		ArmMotor1.set(1);
		ArmMotor2.set(1);	
	}
	public void RaiseArm(double speed) {
		ArmMotor1.set(speed);
		ArmMotor2.set(speed);
	}
    @Override
    protected void initDefaultCommand() {

    }

    @Override
    public void log() {

    }
}
