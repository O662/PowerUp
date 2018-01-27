package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.RobotPreferences;
import org.usfirst.frc.team3335.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class ArmRise extends Command {
	
	boolean finished;
	private static Preferences prefs = Preferences.getInstance();
	private static final double kP = prefs.getDouble("Vision Kp", RobotPreferences.VISION_KP_DEFAULT);
	private static final double kI = prefs.getDouble("Vision Ki", RobotPreferences.VISION_KI_DEFAULT);
	
	public ArmRise (boolean isFinished) {
		requires(Robot.arm);
		finished = isFinished;
		
		
		
	}
	
	public void inishalize() {
		if(!finished) {
			Robot.arm.RaiseArm(1);
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
