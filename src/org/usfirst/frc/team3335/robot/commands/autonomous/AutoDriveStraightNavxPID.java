package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;
import org.usfirst.frc.team3335.robot.RobotPreferences;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraightNavxPID extends Command {

	private final double feetPerSecond = 4.5; //Mark 1 at .7 voltage
	private double distance;
	private double speedForward;
	private double limitDistance;
	private double limitSpeedForward;
	private long timeFinished = 0;
	private final long TIME_MAX = 5000;//milliseconds
	private long driveTime;
	private final boolean limitSpeedByDistance;
	//private final double FINISH_DRIVE_DIST_ULTRAS_MAX = 0.5* Double.MAX_VALUE;
	//private double finishDriveDistUltras = FINISH_DRIVE_DIST_ULTRAS_MAX;
	private static Preferences prefs = Preferences.getInstance();

	//proportional speed constant
	//private static final double kP = 0.04;//0.03 too small?; 0.06 too big; 0.04 just right for mark 1
	// 0.015
	private static final double kP = prefs.getDouble("Drive Kp", RobotPreferences.DRIVE_KP_DEFAULT);//0.03 too small?; 0.06 too big; 0.04 just right for mark 1

	// integral speed constant
	//private static final double kI = 0; //0.018;\
	// 0.001
	private static final double kI = prefs.getDouble("Drive Ki", RobotPreferences.DRIVE_KI_DEFAULT); //0.018;

	// derivative speed constant
	//private static final double kD = 0; //1.5;
	private static final double kD = prefs.getDouble("Drive Kd", RobotPreferences.DRIVE_KD_DEFAULT); //1.5;

	private static final double kToleranceDegrees = 1.0;
	private final double maxOutputRange = prefs.getDouble("Drive Rotate Max Output Range", RobotPreferences.DRIVE_ROTATE_MAX_OUTPUT_RANGE_DEFAULT);
	private double rotateRate;
	private PIDController turnController;

	public AutoDriveStraightNavxPID(double distance) {
		this(distance, 0.7);
	}

	public AutoDriveStraightNavxPID(double distance, double speed) {
		this(distance, speed, false, 0, 0);
	}

	public AutoDriveStraightNavxPID(double distance, double speed, boolean limit, double limitDistance, double limitSpeed) {
		requires(Robot.driveTrain);
		requires(Robot.navx);

		turnController = new PIDController(kP, kI, kD, Robot.navx.getAHRS(), new MyPidOutput());
		turnController.setInputRange(-180, 180);
		turnController.setOutputRange(-maxOutputRange, maxOutputRange);
		turnController.setAbsoluteTolerance(kToleranceDegrees);
		turnController.setContinuous(true);

		this.speedForward = Math.abs(speed);
		this.distance = distance;
		this.limitSpeedByDistance = limit;
		this.limitDistance = limitDistance;
		this.limitSpeedForward = limitSpeed;
		driveTime = (long)(Math.abs(distance) / feetPerSecond / 12.0 * 1000);
		// TODO remove after testing
		driveTime *= 1.5;
		// end TODO
		if (driveTime > TIME_MAX) driveTime = TIME_MAX;
	}

	protected void initialize() {
		Robot.driveTrain.setBrake(true);
		Robot.driveTrain.zeroEncoders();
		//Robot.driveTrain.setRampRate(5/*20*/);
		Robot.driveTrain.setRampRateTime(2.4); // should be equivalent to rampRate=5
		//Robot.navx.zeroYaw();
		//double setPointAngle = 0;
		//turnController.setSetpoint(setPointAngle);
		turnController.setSetpoint(Robot.navx.getYaw());
		turnController.enable();  // NOTE: this used to be in execute
		timeFinished = System.currentTimeMillis() + TIME_MAX;
	}

	protected void execute() {
		double speed = Math.signum(distance) * speedForward;
		double limitSpeed = Math.signum(distance) * limitSpeedForward;
		if (limitSpeedByDistance) {
			speed = limitSpeedByDistance(speed, distance, limitDistance, limitSpeed);
		}
		//if (Math.abs(finishDriveDistUltras) >= Math.abs(FINISH_DRIVE_DIST_ULTRAS_MAX)) {
		//finishDriveDistUltras = finishDriveDistanceUltrasonics(36);
		//}
		//Robot.driveTrain.drive(speed, speed);
		Robot.driveTrain.driveArcade(speed, rotateRate, false);
	}

	//slows down the speed at end 
	private double limitSpeedByDistance(double speedIn, double maxDistance, double limitDistance, double limitSpeed) {
		if (Math.abs(Robot.driveTrain.getDistance()) > Math.abs(maxDistance) - Math.abs(limitDistance)) {
			return limitSpeed;
		}
		return speedIn;
	}

	@Override
	protected boolean isFinished() {
		double driveTrainDist = Robot.driveTrain.getDistance();
		if (Math.abs(driveTrainDist) > Math.abs(distance))
			return true;
		//if (driveTrainDist > finishDriveDistUltras)
		//	return true;
		if (System.currentTimeMillis() > timeFinished)
			//Robot.driveTrain.setBrake(false);
			return true;
		//if (Robot.ultrasonics.getDistance() <= 24)//12)
		//	return true;
		//if (!Robot.visionTest.isTargetDetected()) {
		//	return true;
		//}
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrain.drive(0, 0);
		//Robot.driveTrain.setBrake(false);
		turnController.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

	private class MyPidOutput implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			//myRobot.drive(output, 0);
			//Robot.driveTrain.drive(output, 0);
			rotateRate = -output;
		}
	}

}
