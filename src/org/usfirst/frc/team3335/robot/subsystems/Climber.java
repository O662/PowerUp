package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem implements LoggableSubsystem {
	//this subsystem is used for the climber and employs a single motor that is used extend the climber
	//in order for it to reach up and grab the bar
	private WPI_TalonSRX climberMotorRight;
	private WPI_TalonSRX climberMotorLeft;
   
    public Climber() {
    	climberMotorRight = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_MOTOR);
    	climberMotorLeft = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_MOTOR);
    }
    protected void initDefaultCommand() {

    }
    
    public void turn() {
    	climberMotorRight.set(1);
    	climberMotorLeft.set(1);
    }

    public void stop() {
    	climberMotorRight.set(0);
    	climberMotorLeft.set(0);
    }
    
    @Override
    public void log() {

    }
}
