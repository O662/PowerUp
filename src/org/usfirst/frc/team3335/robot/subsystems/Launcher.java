package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem implements LoggableSubsystem {
	private WPI_TalonSRX LauncherMotor;
	
	public Launcher() {
		LauncherMotor = new WPI_TalonSRX(RobotMap.LAUNCHER_MOTOR);
	}

	
    public void initDefaultCommand() {
    }

    public void turn() {
    	LauncherMotor.set(1);
    }

    public void stop() {
    	LauncherMotor.set(0);
    }



	@Override
	public void log() {
		// TODO Auto-generated method stub
		
	}
}
	
