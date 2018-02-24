package org.usfirst.frc.team3335.robot.commands.autonomous;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraightNavx extends Command {
	
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
	
	
	
	 public AutoDriveStraightNavx(double distance) {
	    	this(distance, 0.7);
	    }

	    public AutoDriveStraightNavx(double distance, double speed) {
	    	this(distance, speed, false, 0, 0);
	    }
	    
	    public AutoDriveStraightNavx(double distance, double speed, boolean limit, double limitDistance, double limitSpeed) {
	        requires(Robot.driveTrain);
	        requires(Robot.navx);

	        //requires(Robot.visionTest);
	        

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
    	Robot.navx.zeroYaw();
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
	    	double rotateRate = .3;
	    	double rotate = /*-*/Math.signum(Robot.navx.getYaw())*rotateRate;
	    	Robot.driveTrain.driveArcade(speed, rotate, false);
	    	
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }

}
