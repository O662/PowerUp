package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.RobotMap;
import org.usfirst.frc.team3335.robot.commands.ArmWithJoystick;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem implements LoggableSubsystem, PIDSource {
	//this subsystem is for the arm mechanism for grabbing cubes its current design employs two motors that
	//activate simultaneously to bring the arm down 
	private final WPI_TalonSRX motorRight, motorLeft;
	private final Encoder leftEncoder, rightEncoder;
	private final DigitalInput leftLimitSwitch, rightLimitSwitch;
	private final double deadzone = 0.1;
	// TODO fix for 2018 encoders
	//private final double pulsesPerRevolution = 256;
	//private final double encoderToShaftRatio = 3;
	//private final double stage3Ratio = 50.0 / 34.0;
	//double distancePerPulse = Math.PI * wheelDiameter / (encoderToShaftRatio * pulsesPerRevolution);
	//distancePerPulse /= stage3Ratio;
	private PIDSourceType pidSourceType = PIDSourceType.kDisplacement;
	int gearRatio = 125;
	double ticksPerDeg = 4096.0 / 360;
	double encoderscalar = gearRatio * ticksPerDeg;
	Value handValue;

	public Arm() {
		motorRight = new WPI_TalonSRX(RobotMap.ARM_RIGHT_MOTOR);
		motorRight.setInverted(true);
		motorLeft = new WPI_TalonSRX(RobotMap.ARM_LEFT_MOTOR); 
		leftEncoder = new Encoder(RobotMap.ARM_ENCODER_LEFT_A, RobotMap.ARM_ENCODER_LEFT_B,
				RobotMap.ARM_ENCODER_LEFT_REVERSE, EncodingType.k4X);
		leftEncoder.reset();
		rightEncoder = new Encoder(RobotMap.ARM_ENCODER_RIGHT_A, RobotMap.ARM_ENCODER_RIGHT_B,
				RobotMap.ARM_ENCODER_RIGHT_REVERSE, EncodingType.k4X);
		rightEncoder.reset();
		leftLimitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH_LEFT);
		rightLimitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH_RIGHT);

		/* Setup sensors to check status, can also be used for phasing */
		//Hardware.rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		//Hardware.rightMaster.setSensorPhase(false);
		//Hardware.leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		//Hardware.leftMaster.setSensorPhase(false);
		motorRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		motorRight.setSensorPhase(false);
		motorLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);

		motorLeft.setSensorPhase(false);
		//_tal.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		//_tal.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		motorRight.setNeutralMode(NeutralMode.Brake);
		motorLeft.setNeutralMode(NeutralMode.Brake);
		
	}

	public void moveArm(Joystick joystick) {
		moveArm(map(joystick.getRawAxis(1)));
	}

	public void moveArm(double speed) {
		motorRight.set(speed);
		motorLeft.set(speed);
		if(isSwitchClosed()) {
			resetArmPosition();
		}
	}

	public void stop() {
		motorRight.set(0);
		motorLeft.set(0);
	}

	public boolean isSwitchClosed() {
		boolean closed = leftLimitSwitch.get() || rightLimitSwitch.get();
		if(closed) {
			resetArmPosition();
		}
		return closed;
	}
	
	public void resetArmPosition() {
		//leftEncoder.reset();
		//rightEncoder.reset();
		motorRight.setSelectedSensorPosition(0, 0, 0);
		motorLeft.setSelectedSensorPosition(0, 0, 0);
	}
	
	public double getRightPosition() {
		return motorRight.getSelectedSensorPosition(0) /  encoderscalar;
		
	}
	public double getLeftPosition() {
		
		return  motorLeft.getSelectedSensorPosition(0) / encoderscalar;
		
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
		//return centerX;
		//return targetOffsetX;
		return leftEncoder.getDistance();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmWithJoystick());
	}

	public double map(double input) {
		handValue = Robot.glove.getValue();
		double scalar = .3;
		if (handValue == Value.kReverse) {
			scalar = .3;
		}
		else if (handValue == Value.kForward) {
			scalar = .4;
		}
		
		if (Math.abs(input) < deadzone) {
			return 0;
		}
		if (input > 0) {
			if(pidGet() > 70) {
				return 0;
			}
			else
			return scalar * (input - deadzone)/(1 - deadzone);
		} else if (input < 0) {
			return scalar * (input + deadzone)/(1 - deadzone);
		} else {
			return 0;
		}
	}

	@Override
	public void log() {
		SmartDashboard.putNumber("Arm: right position", getRightPosition());
		SmartDashboard.putNumber("Arm: left position", getLeftPosition());
		
		/* Output value to SmartDashboard */
		//SmartDashboard.putNumber("Right Sensor position", Hardware.rightMaster.getSelectedSensorPosition(0));
		//SmartDashboard.putNumber("Left Sensor Velocity", Hardware.leftMaster.getSelectedSensorVelocity(0));

		//motorRight.set(ControlMode.Position, value);
		//SmartDashboard.putNumber("Arm: distance", getDistance());
		SmartDashboard.putNumber("Arm: right distance", rightEncoder.getDistance());
		//SmartDashboard.putNumber("Arm: right velocity", rightEncoder.getRate());
		SmartDashboard.putNumber("Arm: left distance", leftEncoder.getDistance());
		//SmartDashboard.putNumber("Arm: left velocity", leftEncoder.getRate());
		SmartDashboard.putNumber("Arm: right motor current", motorRight.getOutputCurrent());
		SmartDashboard.putNumber("Arm: left motor current", motorLeft.getOutputCurrent());
		SmartDashboard.putBoolean("Arm: left limit switch", leftLimitSwitch.get());
		SmartDashboard.putBoolean("Arm: right limit switch", rightLimitSwitch.get());
	}
}
