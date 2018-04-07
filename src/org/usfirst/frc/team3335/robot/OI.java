package org.usfirst.frc.team3335.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team3335.robot.commands.*;
//import org.usfirst.frc.team3335.robot.commands.autonomous.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joystick;
	private Joystick joystick2;
	
	
	//Small class to handle POV like triggers
	private class POVTrigger extends Trigger{
		/*
		 * Positions
		 * 		7	0	1
		 * 		6	-1	2
		 * 		5	4	3
		 * 		
		 */
		private int degrees;
		private Joystick joy;
		//Make sure to call using -1 through 7, else all dies...
		public POVTrigger(Joystick joy, int position) {
			degrees = position*45;
			this.joy = joy;
		}

		@Override
		public boolean get() {
			// TODO Auto-generated method stub
			return joy.getPOV(0)==degrees;
		}
	}

	public OI() throws InterruptedException {
		joystick = new Joystick(0);
		joystick2 = new Joystick(1);

		// Joystick 1
		//int bDefault = -1;
		//int bLaunchCubeReverse = 2;
		//int bLaunchCube = 3;
		//int bMoveArmDown = 5;//4;
		// bMoveArmUp = 4;//5;
		int bShiftLow = 7;
		int bShiftHigh = 8;//6;
		int bCloseHand = 10;
		int bOpenHand = 11;
		int bToggleHand = 1;
		int bPlaceCubeSwitch = 2;
		int bPneumaticLaunchCube = 6;//3;//8;
		int bSmallLauncher = 5;
		//boolean useToggle = true;
		//bDriveForward = 8;
		//bDriveBackward = 9;
		//pov controls
		int dMoveArmUp = 0;
		int dMoveArmDown = 4;
		int bRaiseLauncher = 10;
		int bLowerLauncher = 11;

        // Joystick 2
        int bArmRollersIn = 3;
        int bArmRollersOut = 2;
		int bSmallestLauncher = 6;
		int bRaiseClimber = 4;
		int bLowerClimber = 5;
		

		// Joystick 1

		// Arm
		double armSpeed = .4;//change to point 4
		double intakeSpeed = 1;
		
		
		/*
		JoystickButton moveArmUp = addButton(getJoystick(), bMoveArmUp, "Move Arm Up");
		moveArmUp.whenPressed(new ArmMove(armSpeed));
		moveArmUp.whenReleased(new ArmMove(0));
		JoystickButton moveArmDown = addButton(getJoystick(), bMoveArmDown, "Move Arm Down");
		moveArmDown.whenPressed(new ArmMove(-armSpeed));
		moveArmDown.whenReleased(new ArmMove(0));
		*/
		
		// D-Pad Arm
		//JoystickButton moveDArmUp = addButton()
		
		Trigger moveDArmUp = new POVTrigger(joystick, dMoveArmUp);
		//moveDArmUp.whenActive(new ArmMove(armSpeed));
		//moveDArmUp.whenInactive(new ArmMove(0));
		moveDArmUp.whileActive(new ArmMove(armSpeed));
		Trigger moveDArmDown = new POVTrigger(joystick, dMoveArmDown);
		//moveDArmDown.whenActive(new ArmMove(-armSpeed));
		//moveDArmDown.whenInactive(new ArmMove(0));
		moveDArmDown.whileActive(new ArmMove(-armSpeed));

		//Arm Intake
		JoystickButton ArmIntake = addButton(getJoystick2(), bArmRollersIn, "Arm Intake In");
		//ArmIntake.whenPressed(new IntakeCube(-intakeSpeed, true));
		//ArmIntake.whenReleased(new IntakeCube(0,false));
		ArmIntake.whileHeld(new IntakeCube(-intakeSpeed, true));
		JoystickButton ArmOuttake = addButton(getJoystick2(), bArmRollersOut, "Arm Intake In");
		//ArmOuttake.whenPressed(new IntakeCube(intakeSpeed, true));
		//ArmOuttake.whenReleased(new IntakeCube(0,false));
		ArmOuttake.whileHeld(new IntakeCube(intakeSpeed, true));
		
		//Climber
		JoystickButton ClimberRaise = addButton(getJoystick2(), bRaiseClimber, "Raise the Climber");
		ClimberRaise.whileHeld(new ClimberRaise());
		JoystickButton ClimberLower = addButton(getJoystick2(), bLowerClimber, "Lower the Climber");
		ClimberLower.whileHeld(new ClimberLower());

		// Launcher
		//JoystickButton launchCube = addButton(getJoystick(), bLaunchCube, "Launch Cube");
		//launchCube.whenPressed(new LaunchCube(true));
		//launchCube.whenReleased(new LaunchCube(false));
		//JoystickButton launchCubeReverse = addButton(getJoystick(), bLaunchCubeReverse, "Launch Cube Reverse");
		//launchCubeReverse.whenPressed(new LaunchCube(true, true));
		//launchCubeReverse.whenReleased(new LaunchCube(false));
		JoystickButton pneumaticLaunchCube = addButton(getJoystick(), bPneumaticLaunchCube, "Pneumatic Launch Cube");
		pneumaticLaunchCube.whenPressed(new LaunchCubeBig());
		JoystickButton  pneumaticSmallLaunch = addButton(getJoystick(), bSmallLauncher, "Pneumatic Small Launch Cube");
		pneumaticSmallLaunch.whenPressed(new LaunchCubeMiddle());
		JoystickButton  pneumaticSmallestLaunch = addButton(getJoystick2(), bSmallestLauncher, "Pneumatic Small Launch Cube");
		pneumaticSmallestLaunch.whenPressed(new LaunchCubeSmall());
		
		//raise and lower launcher
		JoystickButton RaiseLauncher = addButton(getJoystick2(), bRaiseLauncher, "Raise Launcher");
		RaiseLauncher.whenPressed(new ExtendCubeLauncher(false));
		JoystickButton LowerLauncher = addButton(getJoystick2(), bLowerLauncher, "Lower Launcher");
		LowerLauncher.whenPressed(new RetractCubeLauncher());
		
		
		// Ball Shifter
		JoystickButton ballShiftHigh = addButton(getJoystick(), bShiftHigh, "Ball Shifter High");
		ballShiftHigh.whenPressed(new BallShiftHigh());
		JoystickButton ballShiftLow = addButton(getJoystick(), bShiftLow, "Ball Shifter Low");
		ballShiftLow.whenPressed(new BallShiftLow());

		// Hand
		//if (useToggle ) {
		JoystickButton toggleHand = addButton(getJoystick(), bToggleHand, "Toggle Hand");
		toggleHand.whenPressed(new HandToggle());
		//JoystickButton toggleHand2 = addButton(getJoystick2(), bToggleHand, "Toggle Hand 2");
		//toggleHand2.whenPressed(new HandToggle());
		//}
		//else {
		JoystickButton closeHand = addButton(getJoystick(), bCloseHand, "Close Hand");
		closeHand.whenPressed(new Hand(false));
		JoystickButton openHand = addButton(getJoystick(), bOpenHand, "Open Hand");
		openHand.whenPressed(new Hand(true));
		//}

		// Place Cube in Switch
		JoystickButton placeCubeSwitch = addButton(getJoystick(), bPlaceCubeSwitch, "Place Cube in Switch");
		placeCubeSwitch.whenPressed(new PlaceCubeInSwitch(1));

		// Drive Mode: Front is Forward vs Back is Forward
		/*
        JoystickButton driveForward = addButton(getJoystick(), bDriveForward, "Drive Forward");
        driveForward.whenPressed(new SetDirection(true));
        JoystickButton driveBackward = addButton(getJoystick(), bDriveBackward, "Drive Backward");
        driveBackward.whenPressed(new SetDirection(false));
		*/

		// Joystick 2

		// Rope climber
		/*
        JoystickButton climbUpSlow = addButton(getJoystick2(), bClimberUpSlow, "Rope Climber Up Slow");
        climbUpSlow.whenPressed(new Climb(false, 0.5));
        climbUpSlow.whenReleased(new Climb(true, 0));
        JoystickButton climbUpFast = addButton(getJoystick2(), bClimberUpFast, "Rope Climber Up Fast");
        climbUpFast.whenPressed(new Climb(false, 1));
        climbUpFast.whenReleased(new Climb(true, 0));
        JoystickButton climbDownSlow = addButton(getJoystick2(), bClimberDownSlow, "Rope Climber Down Slow");
        climbDownSlow.whenPressed(new Climb(false, -0.5));
        climbDownSlow.whenReleased(new Climb(true, 0));
        JoystickButton climbDownFast = addButton(getJoystick2(), bClimberDownFast, "Rope Climber Down Fast");
        climbDownFast.whenPressed(new Climb(false, -1));
        climbDownFast.whenReleased(new Climb(true, 0));
		*/

		// Additional commands to add to dashboard
		/*
		SmartDashboard.putData("AutoTurnToPeg", new AutoTurnToPeg());
		SmartDashboard.putData("AutoSteerDriveToPeg", new AutoSteerDriveToPeg(60, 0.7, 9));
		*/
	}

	private JoystickButton addButton(Joystick joystick, int buttonNumber, String key) {
		JoystickButton button = new JoystickButton(joystick, buttonNumber);
		//TODO uncomment to see commands on dashboard
		//SmartDashboard.putData(key, button);
		return button;
	}

	public Joystick getJoystick() {
		return joystick;
	}

	public Joystick getJoystick2() {
		return joystick2;
	}
}
