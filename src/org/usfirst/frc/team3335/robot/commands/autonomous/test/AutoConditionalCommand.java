package org.usfirst.frc.team3335.robot.commands.autonomous.test;

import org.usfirst.frc.team3335.robot.commands.autonomous.AutoDecideLeft;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Example command to call another command.  Has not been tested.
 *
 * @author macybk@gmail.com
 *
 */
public class AutoConditionalCommand extends Command {

	public AutoConditionalCommand() {
		super();
	}

	@Override
	protected void initialize() {
		super.initialize();
		String msg = DriverStation.getInstance().getGameSpecificMessage();
		if (msg == null || msg.isEmpty() || msg.length() < 3) {
			return;
		}
		Command cmd = null;
		try {
			cmd = new AutoDecideLeft();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cmd != null) {
			cmd.start();
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
