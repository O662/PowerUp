package org.usfirst.frc.team3335.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// Mark 1
	/*
	public static final int DRIVE_TRAIN_FRONT_LEFT = 1;
    public static final int DRIVE_TRAIN_FRONT_RIGHT = 3;
    public static final int DRIVE_TRAIN_BACK_LEFT = 2;
    public static final int DRIVE_TRAIN_BACK_RIGHT = 4;
	public static final int DRIVE_TRAIN_ENCODER_LEFT_A = 0;
    public static final int DRIVE_TRAIN_ENCODER_LEFT_B = 1;
    public static final int DRIVE_TRAIN_ENCODER_RIGHT_A = 2;
    public static final int DRIVE_TRAIN_ENCODER_RIGHT_B = 3;
	public static final int CLIMBING_MOTOR = 5;
	public static final int BALL_SHOOTER_MOTOR = 7;
	public static final int ANALOG_ULTRASONIC_LEFT = 0;
	public static final int ANALOG_ULTRASONIC_RIGHT = 1;
	public static final int BALL_SHIFTER_FORWARD_CHANNEL = 4;
	public static final int BALL_SHIFTER_REVERSE_CHANNEL = 5;
	public static final int GATE_FORWARD_CHANNEL = 0;
	public static final int GATE_REVERSE_CHANNEL = 1;
	*/

	// Mark 2
	/*
	public static final int DRIVE_TRAIN_FRONT_LEFT = 1;
    public static final int DRIVE_TRAIN_FRONT_RIGHT = 3;
    public static final int DRIVE_TRAIN_BACK_LEFT = 2;
    public static final int DRIVE_TRAIN_BACK_RIGHT = 4;
    public static final int DRIVE_TRAIN_FORWARD_DIRECTION = 1;
	public static final int DRIVE_TRAIN_ENCODER_LEFT_A = 8;
    public static final int DRIVE_TRAIN_ENCODER_LEFT_B = 9;
	public static final boolean DRIVE_TRAIN_ENCODER_LEFT_REVERSE = true;
    public static final int DRIVE_TRAIN_ENCODER_RIGHT_A = 3;
    public static final int DRIVE_TRAIN_ENCODER_RIGHT_B = 4;
	public static final boolean DRIVE_TRAIN_ENCODER_RIGHT_REVERSE = false;
	public static final int CLIMBING_MOTOR = 7;
    public static final int INTAKE_MOTOR = 5;
	public static final int BALL_SHOOTER_MOTOR = 6;
	public static final int ANALOG_ULTRASONIC_LEFT = 0;
	public static final int ANALOG_ULTRASONIC_RIGHT = 1;
	public static final int RELAY_CHANNEL = 0;
	// PCM 0
	public static final int FLAPPER_FORWARD_CHANNEL = 4;
	public static final int FLAPPER_REVERSE_CHANNEL = 5;
	public static final int BALL_SHIFTER_FORWARD_CHANNEL = 1;
	public static final int BALL_SHIFTER_REVERSE_CHANNEL = 0;
	public static final int GATE_FORWARD_CHANNEL = 2;
	public static final int GATE_REVERSE_CHANNEL = 3;
	public static final int GEAR_EJECTOR_FORWARD_CHANNEL = 6;
	public static final int GEAR_EJECTOR_REVERSE_CHANNEL = 7;
	// PCM 1
	public static final int GEAR_PICKUP_UP_DOWN_FORWARD_CHANNEL = 0;
	public static final int GEAR_PICKUP_UP_DOWN_REVERSE_CHANNEL = 1;
	public static final int GEAR_PICKUP_OPEN_CLOSE_FORWARD_CHANNEL = 2;
	public static final int GEAR_PICKUP_OPEN_CLOSE_REVERSE_CHANNEL = 3;
	/**/

	// Mark 2
	/**/
	// Miscellaneous
    public static final int DRIVE_TRAIN_FORWARD_DIRECTION = 1;
	public static final int ANALOG_ULTRASONIC_LEFT = 0;
	public static final int ANALOG_ULTRASONIC_RIGHT = 1;
	public static final int RELAY_CHANNEL = 0;

    // Motors
	/** Right drive CIM motor */
	public static final int DRIVE_MOTOR_RIGHT1 = 4; // PDP 3
	/** Right drive MiniCIM motor */
	public static final int DRIVE_MOTOR_RIGHT2 = 7; // PDP 14
	/** Right drive MiniCIM motor */
	public static final int DRIVE_MOTOR_RIGHT3 = 8; // PDP 15
	/** Left drive CIM motor */
	public static final int DRIVE_MOTOR_LEFT1 = 3; // PDP 2
	/** Left drive MiniCIM motor */
	public static final int DRIVE_MOTOR_LEFT2 = 1; // PDP 0
	/** Left drive MiniCIM motor */
	public static final int DRIVE_MOTOR_LEFT3 = 2; // PDP 1
	/** Right arm bag motor */
	public static final int ARM_RIGHT_MOTOR = 5; // PDP 4
	/** Left arm bag motor */
	public static final int ARM_LEFT_MOTOR = 6; // PDP 5
	/** Right launcher/trigger CIM motor */
	public static final int LAUNCHER_RIGHT_MOTOR = 9; // PDP ??
	/** Left launcher/trigger CIM motor */
	public static final int LAUNCHER_LEFT_MOTOR = 10; // PDP ??
	/** Right climber 775 motor */
	public static final int CLIMBER_RIGHT_MOTOR = 11; // PDP ??
	/** Left climber 775 motor */
	public static final int CLIMBER_LEFT_MOTOR = 12; // PDP ??

	// Solenoids: PCM 0
	public static final int BALL_SHIFTER_FORWARD_CHANNEL = 0;
	public static final int BALL_SHIFTER_REVERSE_CHANNEL = 1;
	public static final int GLOVE_FORWARD_CHANNEL = 21;
	public static final int GLOVE_REVERSE_CHANNEL = 31;
	public static final int GLOVE_FORWARD_CHANNEL_2 = 22;
	public static final int GLOVE_REVERSE_CHANNEL_2 = 32;

	// Encoders
	public static final int DRIVE_TRAIN_ENCODER_RIGHT_A = 0;//3;//2; //3?
	public static final int DRIVE_TRAIN_ENCODER_RIGHT_B = 1;//4;//3; //4?
	public static final boolean DRIVE_TRAIN_ENCODER_RIGHT_REVERSE = true;
	public static final int DRIVE_TRAIN_ENCODER_LEFT_A = 2;//8;//1; //8?
	public static final int DRIVE_TRAIN_ENCODER_LEFT_B = 3;//9;//0; //9?
	public static final boolean DRIVE_TRAIN_ENCODER_LEFT_REVERSE = false;
	public static final int ARM_ENCODER_RIGHT_A= 1;
	public static final int ARM_ENCODER_RIGHT_B = 2;
	public static final boolean ARM_ENCODER_RIGHT_REVERSE = false;
	public static final int ARM_ENCODER_LEFT_A = 0;
	public static final int ARM_ENCODER_LEFT_B = 3;
	public static final boolean ARM_ENCODER_LEFT_REVERSE = false;
	public static final int LAUNCHER_ENCODER_A = 4;
	public static final int LAUNCHER_ENCODER_B = 5;
	public static final boolean LAUNCHER_ENCODER_REVERSE = false;
	/**/
}
