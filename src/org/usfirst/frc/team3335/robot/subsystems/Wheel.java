package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Wheel extends Subsystem implements LoggableSubsystem {
	private WPI_TalonSRX WheelMotor;
	
	public Wheel() {
		WheelMotor = new WPI_TalonSRX(RobotMap.WHEEL_MOTOR);
	}

	
	
	
    public void initDefaultCommand() {
    }

    public void turn() {
    	WheelMotor.set(1);
    }

    public void stop() {
    	WheelMotor.set(0);
    }



	@Override
	public void log() {
		// TODO Auto-generated method stub
		
	}
}
	
