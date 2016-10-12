package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.Constants;

import edu.wpi.first.wpilibj.Timer;

public class QuickTurn extends CommandBase {

	final double speed;
	final double time;
	private final Timer timer;
	boolean left;
	
	public QuickTurn(boolean left) {
		requires(drivetrain);
		timer = new Timer();
		if(left == true) {
			speed = -Constants.TURN_SPEED;
		} else {
			speed = Constants.TURN_SPEED;
		}
		time = Constants.TURN_TIME;
	}
	
	@Override
	protected void initialize() {
		timer.reset();
		timer.start();
		
	}

	@Override
	protected void execute() {
		drivetrain.tankDrive(speed, -speed);
	}

	@Override
	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	@Override
	protected void end() {
		drivetrain.stopAll();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
