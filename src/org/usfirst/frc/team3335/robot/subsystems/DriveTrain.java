package org.usfirst.frc.team3335.robot.subsystems;


import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.RobotMap;
import org.usfirst.frc.team3335.robot.RobotPreferences;
import org.usfirst.frc.team3335.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/**
 * Created by jacob on 1/14/17.
 * A subsystem for a west coast drive train.
 */
public class DriveTrain extends Subsystem implements LoggableSubsystem, PIDSource {

	//get the cantalons at http://www.ctr-electronics.com/downloads/installers/CTRE%20Toolsuite%20v4.4.1.9-nonadmin.zip for windows,
	//http://www.ctr-electronics.com//downloads/lib/CTRE_FRCLibs_NON-WINDOWS_v4.4.1.9.zip for other
	// Grayhill 63R256 encoder optical
	private final WPI_TalonSRX /*motorLeft1,*/ motorLeft2, motorLeft3;
	private final WPI_TalonSRX /*motorRight1,*/ motorRight2, motorRight3;
	private final DifferentialDrive drive;
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
	private final boolean useTankDrive = false;
	private final double deadzone = 0.1;
	private final double trainingSpeedMax = 1;
	private int direction = RobotMap.DRIVE_TRAIN_FORWARD_DIRECTION; // Mark2 = 1; Mark3 = -1
	//private final double joystickScalar = 1/(1-deadzone);
	private PIDSourceType pidSourceType = PIDSourceType.kDisplacement;
	private final double voltageRampRateDefault = 150;

	/*
	 * TODO Fix for 2018
	 * 
	 * Encoder Ratios
	 * 
	 * Vex Planetary #217-2615
	 * 
	 * 36:12 ENCODER:SHAFT (encoder spins 3X faster)
	 * 
	 * 2.27x spread between high and low gear [60:24 / 44:40 = 2.5/1.1 = 2.2727]
	 * 
	 * 1st stage:             40:12 [3.3333x]
	 * 2nd stage (low gear):  60:24 [2.5000x]
	 * 2nd stage (high gear): 44:40 [1.1000x]
	 * 3rd stage:             50:34 [1.4706x]
	 * 
	 * Motor to shaft (low gear): 12.255
	 *               (high gear):  5.392
	 */

	public DriveTrain() {
		super();
		//motorLeft1 = new WPI_TalonSRX(RobotMap.MOTOR_DRIVE_LEFT1);
		motorLeft2 = new WPI_TalonSRX(RobotMap.MOTOR_DRIVE_LEFT2);
		motorLeft3 = new WPI_TalonSRX(RobotMap.MOTOR_DRIVE_LEFT3);
		//motorRight1 = new WPI_TalonSRX(RobotMap.MOTOR_DRIVE_RIGHT1);
		motorRight2 = new WPI_TalonSRX(RobotMap.MOTOR_DRIVE_RIGHT2);
		motorRight3 = new WPI_TalonSRX(RobotMap.MOTOR_DRIVE_RIGHT3);
		SpeedControllerGroup leftGroup = new SpeedControllerGroup(/*motorLeft1, */motorLeft2, motorLeft3);
		SpeedControllerGroup rightGroup = new SpeedControllerGroup(/*motorRight1, */motorRight2, motorRight3);

		leftGroup.set(0);
		rightGroup.set(0);

		double voltageRampRate = voltageRampRateDefault;//20;
		setRampRate(voltageRampRate);

		//backRight.setCurrentLimit(0);

		setBrake(false);

		drive = new DifferentialDrive(leftGroup, rightGroup);

		// Scale encoder pulses to distance in inches
		// TODO adjust parameters for 2018
		double wheelDiameter = 6.0; // inches
		double encoderToShaftRatio = 3; // 3X gear reduction
		double pulsesPerRevolution = 256;
		double stage3Ratio = 50.0 / 34.0;
		double distancePerPulse = Math.PI * wheelDiameter / (encoderToShaftRatio * pulsesPerRevolution);
		distancePerPulse /= stage3Ratio;

		leftEncoder = new Encoder(RobotMap.DRIVE_TRAIN_ENCODER_LEFT_A, RobotMap.DRIVE_TRAIN_ENCODER_LEFT_B,
				RobotMap.DRIVE_TRAIN_ENCODER_LEFT_REVERSE, EncodingType.k4X);
		leftEncoder.reset();
		leftEncoder.setDistancePerPulse(distancePerPulse);
		rightEncoder = new Encoder(RobotMap.DRIVE_TRAIN_ENCODER_RIGHT_A, RobotMap.DRIVE_TRAIN_ENCODER_RIGHT_B,
				RobotMap.DRIVE_TRAIN_ENCODER_RIGHT_REVERSE, EncodingType.k4X);
		rightEncoder.reset();
		rightEncoder.setDistancePerPulse(distancePerPulse);
	}

	public void setBrake(boolean brake) {
		// Formerly: frontLeft.enableBrakeMode(brake);
		// See https://github.com/CrossTheRoadElec/Phoenix-Documentation#installing-phoenix-framework-onto-your-frc-robot
		NeutralMode mode = brake ? NeutralMode.Brake : NeutralMode.Coast;

		//motorLeft1.setNeutralMode(mode);
		motorLeft2.setNeutralMode(mode);
		motorLeft3.setNeutralMode(mode);
		//motorRight1.setNeutralMode(mode);
		motorRight2.setNeutralMode(mode);
		motorRight3.setNeutralMode(mode);
	}

	public void setRampRateTime(double secondsFromNeutralToFull) {
		// See https://github.com/CrossTheRoadElec/Phoenix-Documentation#installing-phoenix-framework-onto-your-frc-robot
		// TODO also see section on limiting current rate, both peak and continuous
		// TODO which will be useful for climbing motors
		// (2, 0) ramps from neutral to full voltage in 2 sec, with no timeout
		//motorLeft1.configOpenloopRamp(secondsFromNeutralToFull, 0);
		motorLeft2.configOpenloopRamp(secondsFromNeutralToFull, 0);
		motorLeft3.configOpenloopRamp(secondsFromNeutralToFull, 0);
		//motorRight1.configOpenloopRamp(secondsFromNeutralToFull, 0);
		motorRight2.configOpenloopRamp(secondsFromNeutralToFull, 0);
		motorRight3.configOpenloopRamp(secondsFromNeutralToFull, 0);
	}

	@Deprecated
	public void setRampRate(double voltageRampRate){
		// Formerly: frontLeft.setVoltageRampRate(voltageRampRate);
		//    where voltageRampRate was in volts/sec???
		//          or was it in percent voltage / sec ???
		//    used 150 as default, and 5 for slow rate during auto
		// Assuming volts/sec, then
		//     150 V/sec is nominal 12V / 150 V/sec = 0.08 sec
		//     5 V/sec is nominal 12V / 5 V/sec = 2.4 sec
		setRampRateTime(12.0 / voltageRampRate);
	}

	public void setDefaltRampRate(){
		double voltageRampRate = voltageRampRateDefault;
		setRampRate(voltageRampRate);
	}

	public void zeroEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

	public void drive(Joystick joystick) {
		//driveOrig(joystick);
		driveNew(joystick);
	}

	public double map(double input ) {
		if (Math.abs(input) < deadzone) {
			return 0;
		}
		if (input>0) {
			return (input - deadzone)/(1 - deadzone);
		} else if(input<0) {
			return (input + deadzone)/(1 - deadzone);
		} else {
			return 0;
		}
	}

	/**
	 *
	 * @param direction : 1 for forward, -1 for backward
	 */
	public void setDirection(int direction) {
		this.direction = direction * RobotMap.DRIVE_TRAIN_FORWARD_DIRECTION;
	}

	public void driveNew(Joystick joystick) {
		if (useTankDrive) {
			int sign = direction;
			if (joystick.getRawAxis(1) <= 0) sign = -direction;
			if (Math.abs(joystick.getRawAxis(1))>trainingSpeedMax) {
				drivePrivate(trainingSpeedMax*sign, map(-joystick.getRawAxis(RobotPreferences.DRIVE_TRAIN_RIGHT_AXIS)));
			} else {
				drivePrivate(map(direction *joystick.getRawAxis(RobotPreferences.DRIVE_TRAIN_LEFT_AXIS)),
						map(direction *joystick.getRawAxis(RobotPreferences.DRIVE_TRAIN_RIGHT_AXIS)));
			}
		} else {
			int sign = direction;
			int turnSign = -1;
			if (joystick.getRawAxis(1) <= 0) sign = -direction;
			if (Math.abs(joystick.getRawAxis(1))>trainingSpeedMax) {
				driveArcadePrivate(sign*trainingSpeedMax, map(/*direction * */ joystick.getRawAxis(0)));
			} else {
				driveArcadePrivate(map(direction *joystick.getRawAxis(1)), turnSign * map(/*direction * */ joystick.getRawAxis(0)));
			}
		}
	}

	public void drive(double left, double right) {
		int sign = RobotMap.DRIVE_TRAIN_FORWARD_DIRECTION == 1 ? -1 : 1;
		drivePrivate(sign * left, sign * right, false/*true*/);
	}

	private void drivePrivate(double left, double right, boolean squareInputs) {
		drive.tankDrive(left, right, squareInputs);
	}

	private void drivePrivate(double left, double right) {
		drive.tankDrive(left, right, true);
	}

	/**
	 * Arcade drive.  Takes into account whether DRIVE_TRAIN_FORWARD_DIRECTION is 1 or -1.
	 * @param move value to move forward/backward
	 * @param rotate value to rotate right/left
	 * @param squared if true, square inputs to decrease sensitivity at low speeds
	 */
	public void driveArcade(double move, double rotate, boolean squared) {
		int sign = RobotMap.DRIVE_TRAIN_FORWARD_DIRECTION == 1 ? -1 : 1;
		drive.arcadeDrive(sign * move, rotate, squared);
		//drive.arcadeDrive(move, rotate, squared);
	}

	private void driveArcadePrivate(double move, double rotate, boolean squared) {
		drive.arcadeDrive(move, rotate, squared);
	}

	private void driveArcadePrivate(double move, double rotate) {
		driveArcadePrivate(move, rotate, true);
	}

	public double getDistance() {
		if (!leftEncoder.getStopped() && !rightEncoder.getStopped()) {
			return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
		} else if (!leftEncoder.getStopped()) {
			return leftEncoder.getDistance();
		} else if (!rightEncoder.getStopped()) {
			return rightEncoder.getDistance();
		} else {
			return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
		}
	}

	public double getLeftDistance() {
		return leftEncoder.getDistance();
	}

	public double getRightDistance() {
		return rightEncoder.getDistance();
	}

	@Override
	public void log() {
		SmartDashboard.putNumber("DriveTrain: distance", getDistance());
		SmartDashboard.putNumber("DriveTrain: left distance", leftEncoder.getDistance());
		SmartDashboard.putNumber("DriveTrain: left velocity", leftEncoder.getRate());
		//SmartDashboard.putNumber("DriveTrain: left raw", leftEncoder.getRaw());
		SmartDashboard.putNumber("DriveTrain: right distance", rightEncoder.getDistance());
		SmartDashboard.putNumber("DriveTrain: right velocity", rightEncoder.getRate());
		//SmartDashboard.putNumber("DriveTrain: right raw", rightEncoder.getRaw());
		//SmartDashboard.putNumber("DriveTrain: left1 (CIM) current", motorLeft1.getOutputCurrent());
		//SmartDashboard.putNumber("DriveTrain: left1 (CIM) current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_DRIVE_LEFT1));
		SmartDashboard.putNumber("DriveTrain: left2 (MiniCIM) current", motorLeft2.getOutputCurrent());
		//SmartDashboard.putNumber("DriveTrain: left2 (MiniCIM) current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_DRIVE_LEFT2));
		SmartDashboard.putNumber("DriveTrain: left3 (MiniCIM) current", motorLeft3.getOutputCurrent());
		//SmartDashboard.putNumber("DriveTrain: left3 (MiniCIM) current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_DRIVE_LEFT3));
		//SmartDashboard.putNumber("DriveTrain: right1 (CIM) current", motorRight1.getOutputCurrent());
		//SmartDashboard.putNumber("DriveTrain: right1 (CIM) current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_DRIVE_RIGHT1));
		SmartDashboard.putNumber("DriveTrain: right2 (MiniCIM) current", motorRight2.getOutputCurrent());
		//SmartDashboard.putNumber("DriveTrain: right2 (MiniCIM) current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_DRIVE_RIGHT2));
		SmartDashboard.putNumber("DriveTrain: right3 (MiniCIM) current", motorRight3.getOutputCurrent());
		//SmartDashboard.putNumber("DriveTrain: right3 (MiniCIM) current pdp", Robot.pdp.getCurrent(RobotMap.PDP_MOTOR_DRIVE_RIGHT3));
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
		return getDistance();
	}
}
