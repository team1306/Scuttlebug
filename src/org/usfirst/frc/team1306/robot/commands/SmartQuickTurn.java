package org.usfirst.frc.team1306.robot.commands;

/**
 * 
 * Quickly turns to a certain degree measure
 * 
 * @author Sam Roquitte
 *
 */

public class SmartQuickTurn extends CommandBase {

	final double speed = 0;
	final double degree = 0;
	boolean isDoneTurning = false;
	
	public SmartQuickTurn(boolean left, double degree) {
		requires(drivetrain);
		if(left == true) {
			
		} else {
			
		}
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		drivetrain.tankDrive(speed, -speed);
	}

	@Override
	protected boolean isFinished() {
		return isDoneTurning;
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
