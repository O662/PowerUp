package org.usfirst.frc.team3335.robot.commands;


import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.RobotPreferences;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class ArmRise extends Command {

	boolean finished;
	private static final Preferences prefs = Preferences.getInstance();
	private static final double kP = prefs.getDouble("Vision Kp", RobotPreferences.VISION_KP_DEFAULT);
	private static final double kI = prefs.getDouble("Vision Ki", RobotPreferences.VISION_KI_DEFAULT);
	private static final double kD = prefs.getDouble("Vision Kd", RobotPreferences.VISION_KD_DEFAULT);
	private final double maxOutputRange = prefs.getDouble("Vision Max Output Range", RobotPreferences.VISION_MAX_OUTPUT_RANGE_DEFAULT);
	private double rotateRate;
	// Setpoint angle
	private double setPointAngle;
	// tolerance in degrees
	private static final double kToleranceDegrees = 1.0;
	private PIDController turnController;

	public ArmRise () {
		requires(Robot.arm);
	}

	public void initialize() {
		turnController = new PIDController(kP,kI,kD,Robot.arm,new MyPidOutput());
		turnController.setInputRange(-180, 180);
		turnController.setOutputRange(-maxOutputRange, maxOutputRange);
		turnController.setAbsoluteTolerance(kToleranceDegrees);
		turnController.setContinuous(true);
		turnController.setSetpoint(90);
	}

	public void Execute() {
		turnController.enable();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	public class MyPidOutput implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			//myRobot.drive(output, 0);
			//Robot.driveTrain.drive(output, 0);
			rotateRate = output;
		}
	}

}
