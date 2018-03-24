/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3335.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;

import org.usfirst.frc.team3335.robot.commands.autonomous.*;
import org.usfirst.frc.team3335.robot.subsystems.*;
import org.usfirst.frc.team3335.robot.subsystems.vision.VisionTarget;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	SendableChooser<String> autoChooser = new SendableChooser<String>();

	final String AUTO_NONE = "None";
	final String AUTO_DRIVE_STRAIGHT = "Auto Drive Straight";
	final String AUTO_DECIDE_LEFT = "Auto Decide Left";
	final String AUTO_DECIDE_RIGHT = "Auto Decide Right";
	final String AUTO_DECIDE_MIDDLE = "Auto Decide Middle";
	final String AUTO_DRIVE_STRAIGHT_LOWER_ARMS = "Auto Drive Straight Lower Arms";
	

	// List of subsystems, convenient for logging, etc.
	private ArrayList<LoggableSubsystem> subsystemsList = new ArrayList<LoggableSubsystem>();

	// Subsystems
	//public static Compressor compressor;
	public static DriveTrain driveTrain;
	public static Vision vision;
	public static VisionTarget visionTarget;
	//public static CameraStream gearPickupCameraStream;
	public static BallShifter ballShifter;
	//public static Climber climber;
	public static NavX navx;
	public static PneumaticLauncher pneumaticLauncher;
	public static Arm arm;
	public static Glove glove;
	public static DoubleUltrasonic doubleUltrasonic;
	public static SingleUltrasonic singleUltrasonic;
	public static ArmIntake armIntake;

	public static PowerDistributionPanel pdp;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Instantiate subsystems and add to subsystem list (e.g., for logging to dashboard)
		pdp = new PowerDistributionPanel();

		//compressor = new Compressor();
		//subsystemsList.add(compressor);

		driveTrain = new DriveTrain();
		subsystemsList.add(driveTrain);

		//vision = new Vision();
		//subsystemsList.add(vision);
		vision = null;

		visionTarget = new VisionTarget();
		subsystemsList.add(visionTarget);
		//vision = null;

		//gearPickupCameraStream = new CameraStream();
		//subsystemsList.add(gearPickupCameraStream);

		//climber = new Climber();
		//subsystemsList.add(climber);

		navx = new NavX();
		subsystemsList.add(navx);
		
		arm = new Arm();
		subsystemsList.add(arm);

		glove = new Glove();
		subsystemsList.add(glove);
		
		pneumaticLauncher = new PneumaticLauncher();
		subsystemsList.add(pneumaticLauncher);
		
		ballShifter = new BallShifter();
		subsystemsList.add(ballShifter);
		//ballShifter = null;

		doubleUltrasonic = new DoubleUltrasonic();
		subsystemsList.add(doubleUltrasonic);
		
		armIntake = new ArmIntake();
		subsystemsList.add(armIntake);

		//singleUltrasonic = new SingleUltrasonic();
		//subsystemsList.add(singleUltrasonic);


		// Autonomous
		//chooser.addObject("AutoDriveToPeg", new AutoDriveToPeg(60));
		//chooser.addObject("Auto Drive Straight 9ft", new AutoPlaceGear(108, 0, 0));
		//chooser.addObject("Auto Place Gear Turn Right", new AutoPlaceGear(90, 60, 60));
		//chooser.addObject("Auto Drive Straight 6ft", new AutoPlaceGear(80, 0, 0));
		//chooser.addObject("Auto Place Gear Turn Left", new AutoPlaceGear(90, -60, 60));
		//chooser.addObject("Auto Place and Drop Gear Straight", 
		//		new AutoPlaceDropGear(70/*110*/, 0, 0, -20, 0.5)); // ~108in dist minus ~29in robot length
		//chooser.addObject("Auto Turn using Vision", new AutoTurnByVision());
		//chooser.addObject("Auto Turn using Vision Simple", new AutoTurnByVisionSimple());
		//chooser.addObject("Auto Place Gear using Vision Simple Turn Right", new AutoPlaceDropGearVision(80, 60, 66, -20, 0.5));
		//chooser.addObject("Auto Place Gear using Vision Simple Straight", new AutoPlaceDropGearVision(0, 0, 80, -20, 0.5));
		//chooser.addObject("Auto Place Gear using Vision Simple Turn Left", new AutoPlaceDropGearVision(80, -60, 66, -20, 0.5));
		//chooser.addObject("Auto Place Gear using Vision Simple", new AutoPlaceDropGearVision(1, 60, 0, -20, 0.5));
		/**/
//		chooser.addObject("Auto Turn To Peg", new AutoTurnToPeg());
//		chooser.addObject("Auto Turn Right & Drive To Peg (Vision Target)", new AutoPlaceDropGearVisionTurnPID(76, 58, 66, -20, 0.5));
//		chooser.addObject("Auto Turn Straight & Drive To Peg (Vision Target)", new AutoPlaceDropGearVisionTurnPID(0, 0, 80, -20, 0.5));
//		chooser.addObject("Auto Turn Left & Drive To Peg (Vision Target)", new AutoPlaceDropGearVisionTurnPID(76, -48/*?*/, 66, -20, 0.5));
//		chooser.addObject("Auto Turn Right & Drive To Peg (new Vision Target)", new AutoPlaceDropGearVisionTurnPID3(72, 58, 66, -20, 0.5));
//		chooser.addObject("Auto Turn Straight & Drive To Peg (new Vision Target)", new AutoPlaceDropGearVisionTurnPID3(0, 0, 80, -20, 0.5));
//		chooser.addObject("Auto Turn Left & Drive To Peg (new Vision Target)", new AutoPlaceDropGearVisionTurnPID3(72, -48, 66, -20, 0.5));
		/**/
		//chooser.addObject("Auto Turn To Peg Simple", new AutoTurnToPegSimple(60, 0.5));
		//chooser.addObject("Auto Turn To Peg Encoder", new AutoTurnToPegEncoders(-60, 0.5));
		//chooser.addObject("Auto Drive Distance", new AutoDriveDistance(108, 10000));
		chooser.addDefault("None", new AutoNone());
//		double distance = 36;
//		chooser.addObject("Auto Drive Straight", new AutoDriveStraight(110, 0.3));
//		SmartDashboard.putData("Auto Mode", chooser);
//		chooser.addObject("Auto Drive Straight NAVX", new AutoDriveStraightNavx(distance, 0.3));
//		chooser.addObject("Auto Drive Straight NAVX PID", new AutoDriveStraightNavxPID(distance, 0.3));
//		chooser.addObject("Auto Drive Turn to Scale", new AutoDriveTurnToScale(90, 0.4));
//		chooser.addObject("Auto Drive To Scale and Turn", new AutoDriveToScaleTurn(distance, 0.5, 90.0, 0.5));
//		//chooser.addObject("Auto Decide Left", new AutoDecideLeft());
//		//chooser.addObject("Auto Decide middle", new AutoDecideMiddle());
//		//chooser.addObject("Auto Decide Right", new AutoDecideRight());
//		chooser.addObject("Auto Middle Go Right", new AutoMiddle());

		// New string-based chooser for auto
		autoChooser.addDefault(AUTO_NONE, AUTO_NONE);
		autoChooser.addObject(AUTO_DRIVE_STRAIGHT, AUTO_DRIVE_STRAIGHT);
		autoChooser.addObject(AUTO_DECIDE_LEFT, AUTO_DECIDE_LEFT);
		autoChooser.addObject(AUTO_DECIDE_RIGHT, AUTO_DECIDE_RIGHT);
		autoChooser.addObject(AUTO_DECIDE_MIDDLE, AUTO_DECIDE_MIDDLE);
		autoChooser.addObject(AUTO_DRIVE_STRAIGHT_LOWER_ARMS, AUTO_DRIVE_STRAIGHT_LOWER_ARMS);
		SmartDashboard.putData("Auto (String) Mode", autoChooser);

		// Preferences
		Preferences prefs = Preferences.getInstance();
		SmartDashboard.putNumber("Prefs: Drive Kp", prefs.getDouble("Drive Kp", RobotPreferences.DRIVE_KP_DEFAULT));
		SmartDashboard.putNumber("Prefs: Drive Ki", prefs.getDouble("Drive Ki", RobotPreferences.DRIVE_KI_DEFAULT));
		SmartDashboard.putNumber("Prefs: Drive Kd", prefs.getDouble("Drive Kd", RobotPreferences.DRIVE_KD_DEFAULT));
		SmartDashboard.putNumber("Prefs: Drive Rotate Max Output Range", prefs.getDouble("Drive Rotate Max Output Range", RobotPreferences.DRIVE_ROTATE_MAX_OUTPUT_RANGE_DEFAULT));
		SmartDashboard.putNumber("Prefs: Vision Kp", prefs.getDouble("Vision Kp", RobotPreferences.VISION_KP_DEFAULT));
		SmartDashboard.putNumber("Prefs: Vision Ki", prefs.getDouble("Vision Ki", RobotPreferences.VISION_KI_DEFAULT));
		SmartDashboard.putNumber("Prefs: Vision Kd", prefs.getDouble("Vision Kd", RobotPreferences.VISION_KD_DEFAULT));
		SmartDashboard.putNumber("Prefs: Vision Max Output Range", prefs.getDouble("Vision Max Output Range", RobotPreferences.VISION_MAX_OUTPUT_RANGE_DEFAULT));
		SmartDashboard.putNumber("Prefs: Vision Update Delay", prefs.getLong("Vision Update Delay", RobotPreferences.VISION_UPDATE_DELAY_DEFAULT));
		SmartDashboard.putNumber("Prefs: Turn To Peg Angle", prefs.getDouble("Turn To Peg Angle", RobotPreferences.TURN_TO_PEG_ANGLE_DEFAULT));
		SmartDashboard.putNumber("Prefs: Vision Time Limit", prefs.getDouble("Auto Vision Time Limit", RobotPreferences.VISION_TIME_DEFAULT));
		SmartDashboard.putNumber("Prefs: Auto Turn Vision Simple Forward Speed", prefs.getDouble("Auto Turn Vision Simple Forward Speed", RobotPreferences.AUTO_TURN_VISION_SIMPLE_FORWARD_SPEED_DEFAULT));
		SmartDashboard.putNumber("Prefs: Auto Turn Vision Simple Rotate Speed", prefs.getDouble("Auto Turn Vision Simple Rotate Speed", RobotPreferences.AUTO_TURN_VISION_SIMPLE_ROTATE_SPEED_DEFAULT));

		//Instantiate after all subsystems and preferences - or the world will die
		//We don't want that, do we?
		oi = new OI();

		//TODO uncomment to see subsystems on dashboard
		//addSubsystemsToDashboard(subsystemsList);
		ArrayList<LoggableSubsystem> tempList = new ArrayList<LoggableSubsystem>();
		tempList.add(driveTrain);
		addSubsystemsToDashboard(tempList);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		int counter = 0;
		while(true) {
			counter++;
			if (isGameDataValid()) {
				break;
			} else {
				DriverStation.reportWarning("Game data not valid, retry #" + counter, false);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (counter > 100) {
				break;
			}
		}
		
		autonomousCommand = chooser.getSelected();

		
		switch(autoChooser.getSelected()) {
		case AUTO_DECIDE_LEFT:
			autonomousCommand = new AutoDecideLeft();
			break;
		case AUTO_DECIDE_RIGHT:
			autonomousCommand = new AutoDecideRight();
			break;
		case AUTO_DECIDE_MIDDLE:
			autonomousCommand = new AutoDecideMiddle();
			break;
		case AUTO_DRIVE_STRAIGHT:
			autonomousCommand = new AutoDriveStraight(110,.3);
			break;
		case AUTO_DRIVE_STRAIGHT_LOWER_ARMS:
			autonomousCommand = new AutoDriveStraightLowerArms();
			break;
		case AUTO_NONE:
		default:
			autonomousCommand = new AutoNone();
			break;
		}
		

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	private void log() {
		for (LoggableSubsystem subsystem : subsystemsList) {
			if (subsystem != null) {
				subsystem.log();
			}
		}
	}

	/**
	 * Log subsystems on the SmartDashboard
	 * @param subsystems list of subsystems
	 */
	private void addSubsystemsToDashboard(ArrayList<LoggableSubsystem> subsystems) {
		for (LoggableSubsystem subsystem : subsystems) {
			if (subsystem != null && subsystem instanceof Subsystem) {
				SmartDashboard.putData((Subsystem) subsystem);
			}
		}
	}
	
	private boolean isGameDataValid() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null || gameData.isEmpty() || gameData.length() < 3) {
			return false;
		}
		for(int i=0; i<3;i++) {
			char letter = gameData.charAt(i);
			if (!(letter == 'R' || letter == 'L')) {
				return false;
			}
			
			
		}
		return true;
	}
}
