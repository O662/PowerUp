package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem implements LoggableSubsystem {
	//this subsystem is for the arm mechenism for grabing cubes its current design employs two motors that
	//activate simultaniusly to bring the arm down 
	private WPI_TalonSRX ArmMotor1, ArmMotor2;
	
	public Arm() {
		ArmMotor1 = new WPI_TalonSRX(RobotMap.ARM_MOTOR_1);
		ArmMotor2 = new WPI_TalonSRX(RobotMap.ARM_MOTOR_2); 
	
		
	}
    @Override
    protected void initDefaultCommand() {

    }

    @Override
    public void log() {

    }
}
