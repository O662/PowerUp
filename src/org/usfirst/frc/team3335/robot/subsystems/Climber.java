package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem implements LoggableSubsystem {
	private WPI_TalonSRX ClimberMotor;
   
    public Climber() {
    	ClimberMotor = new WPI_TalonSRX(RobotMap.CLIMBER_MOTOR);
    }
    protected void initDefaultCommand() {

    }
    
    public void turn() {
    	ClimberMotor.set(1);
    }

    public void stop() {
    	ClimberMotor.set(0);
    }
    
    @Override
    public void log() {

    }
}
