package org.usfirst.frc.team3335.robot.commands;

import org.usfirst.frc.team3335.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class Hand extends Command {
	
private DoubleSolenoid.Value val;
	
	/**
	 * constructor
	 * @param f true = falpperDown;//flase = flapperUP
	 */
	public Hand(boolean f) {
        requires(Robot.glove);
        val = f ? Value.kForward : Value.kReverse;
    }

    @Override
    protected void initialize() {
        Robot.glove.switchPos(val);
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
