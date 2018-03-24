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

	
	// Mark 2 and Mark 3
	public static final boolean isMark3 = false; // = true for Mark 3; false for Mark 2

	// Miscellaneous
    public static final int DRIVE_TRAIN_FORWARD_DIRECTION = 1;
	public static final int ANALOG_ULTRASONIC_BACK_LEFT = 0;
	public static final int ANALOG_ULTRASONIC_BACK_RIGHT = 1;
	public static final int ANALOG_ULTRASONIC_FRONT = 2;
	//public static final int RELAY_CHANNEL = 0; // PCM module for light ring instead

    // Motors
	/** Right drive CIM motor */
	public static final int MOTOR_DRIVE_RIGHT1 = 4;
	/** Right drive MiniCIM motor */
	public static final int MOTOR_DRIVE_RIGHT2 = 7;
	/** Right drive MiniCIM motor */
	public static final int MOTOR_DRIVE_RIGHT3 = 8;
	/** Left drive CIM motor */
	public static final int MOTOR_DRIVE_LEFT1 = 3;
	/** Left drive MiniCIM motor */
	public static final int MOTOR_DRIVE_LEFT2 = 1;
	/** Left drive MiniCIM motor */
	public static final int MOTOR_DRIVE_LEFT3 = 2;
	/** Right arm bag motor */
	public static final int ARM_RIGHT_MOTOR = 5;
	/** Left arm bag motor */
	public static final int ARM_LEFT_MOTOR = 6;
	
	public static final int CLIMBER_MOTOR = 9;
	/** Right launcher/trigger CIM motor */
	public static final int LAUNCHER_RIGHT_MOTOR = 9;
	/** Left launcher/trigger CIM motor */
	public static final int LAUNCHER_LEFT_MOTOR = 10;
	/** Right climber 775 motor */
	public static final int CLIMBER_RIGHT_MOTOR = 11;
	/** Left climber 775 motor */
	public static final int CLIMBER_LEFT_MOTOR = 12;

	// Solenoids: PCM 0
	public static final int BALL_SHIFTER_PCM_MODULE = 0;
	public static final int BALL_SHIFTER_FORWARD_CHANNEL = 0;
	public static final int BALL_SHIFTER_REVERSE_CHANNEL = 1;
	public static final int GLOVE_PCM_MODULE = 0;
	public static final int GLOVE_FORWARD_CHANNEL = 2;
	public static final int GLOVE_REVERSE_CHANNEL = 3;
	//public static final int GLOVE_FORWARD_CHANNEL_2 = 4;
	//public static final int GLOVE_REVERSE_CHANNEL_2 = 5;
	public static final int LIGHT_RING_PCM_MODULE = 0;
	public static final int LIGHT_RING_CHANNEL = 4;

	//Solenoids:PCM 1
	public static final int LAUNCHER_PCM_MODULE = 1;
	public static final int LAUNCHER_LEFT_FORWARD_CHANNEL = 7;//0;
	public static final int LAUNCHER_LEFT_REVERSE_CHANNEL = 1;
	public static final int LAUNCHER_CENTER_FORWARD_CHANNEL = 2;
	public static final int LAUNCHER_CENTER_REVERSE_CHANNEL = 3; 
	public static final int LAUNCHER_RIGHT_FORWARD_CHANNEL = 4;
	public static final int LAUNCHER_RIGHT_REVERSE_CHANNEL = 5;
	//public static final int LAUNCHER_FORWARD_CHANNEL = 2;
	//public static final int LAUNCHER_FORWARD_CHANNEL_2 = 4;
	//public static final int LAUNCHER_FORWARD_CHANNEL_3 = 6;
	//public static final int LAUNCHER_REVERSE_CHANNEL = 3;
	//public static final int LAUNCHER_REVERSE_CHANNEL_2 = 5;
	//public static final int LAUNCHER_REVERSE_CHANNEL_3 = 7;

	// Encoders
	public static final int DRIVE_TRAIN_ENCODER_RIGHT_A = 0;//3;//2; //3?
	public static final int DRIVE_TRAIN_ENCODER_RIGHT_B = 1;//4;//3; //4?
	public static final boolean DRIVE_TRAIN_ENCODER_RIGHT_REVERSE = true;
	public static final int DRIVE_TRAIN_ENCODER_LEFT_A = 2;//8;//1; //8?
	public static final int DRIVE_TRAIN_ENCODER_LEFT_B = 3;//9;//0; //9?
	public static final boolean DRIVE_TRAIN_ENCODER_LEFT_REVERSE = false;
	public static final int ARM_ENCODER_RIGHT_A= 21;
	public static final int ARM_ENCODER_RIGHT_B = 22;
	public static final boolean ARM_ENCODER_RIGHT_REVERSE = false;
	public static final int ARM_ENCODER_LEFT_A = 20;
	public static final int ARM_ENCODER_LEFT_B = 23;
	public static final boolean ARM_ENCODER_LEFT_REVERSE = false;
	public static final int LAUNCHER_ENCODER_A = 4;
	public static final int LAUNCHER_ENCODER_B = 5;
	public static final boolean LAUNCHER_ENCODER_REVERSE = false;
	public static final int ARM_LIMIT_SWITCH_RIGHT = 8;
	public static final int ARM_LIMIT_SWITCH_LEFT = 9;

	// PDP channels for motors on Mark 2 and Mark 3
	public static final int PDP_MOTOR_DRIVE_RIGHT1 = isMark3 ? 0 : 3;
	public static final int PDP_MOTOR_DRIVE_RIGHT2 = isMark3 ? 1 : 14;
	public static final int PDP_MOTOR_DRIVE_RIGHT3 = isMark3 ? 2 : 15;
	public static final int PDP_MOTOR_DRIVE_LEFT1 = isMark3 ? 13 : 2;
	public static final int PDP_MOTOR_DRIVE_LEFT2 = isMark3 ? 15 : 0;
	public static final int PDP_MOTOR_DRIVE_LEFT3 = isMark3 ? 14 : 1;
	public static final int PDP_MOTOR_ARM_RIGHT = isMark3 ? 7 : 4;
	public static final int PDP_MOTOR_ARM_LEFT = isMark3 ? 8 : 5;
	public static final int PDP_MOTOR_LAUNCHER_RIGHT = isMark3 ? 12 : 13;
	public static final int PDP_MOTOR_LAUNCHER_LEFT = isMark3 ? 3 : 12;
	public static final int PDP_MOTOR_CLIMBER_RIGHT = isMark3 ? 9 : 11;
	public static final int PDP_MOTOR_CLIMBER_LEFT = isMark3 ? 6 : 10;
}
