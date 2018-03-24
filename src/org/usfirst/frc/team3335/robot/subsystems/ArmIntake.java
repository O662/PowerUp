package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmIntake extends Subsystem implements LoggableSubsystem{
	
	private final WPI_TalonSRX motorRight, motorLeft;

	public ArmIntake() {
		
		motorRight = new WPI_TalonSRX(RobotMap.ARM_INTAKE_RIGHT_MOTOR);
		motorLeft = new WPI_TalonSRX(RobotMap.ARM_INTAKE_LEFT_MOTOR);

		motorRight.setNeutralMode(NeutralMode.Brake);
		motorLeft.setNeutralMode(NeutralMode.Brake);
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
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}


	@Override
	public void log() {
		// TODO Auto-generated method stub
		
	}

}
