package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class HandToggle extends Command{

	private DoubleSolenoid.Value val;
	
	public HandToggle() {
		requires(Robot.glove);
		val = Robot.glove.handState? Value.kReverse : Value.kForward;
		Robot.glove.handState = !Robot.glove.handState;
	}

	@Override
	protected void initialize() {
		//Robot.glove.switchPos(val);
		Robot.glove.toggle();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
