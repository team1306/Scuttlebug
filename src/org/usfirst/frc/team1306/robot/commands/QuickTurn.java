package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.Constants;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Timer;

<<<<<<< HEAD
=======
/**
 * 
 * Quickly turns right or left.
 * 
 * @author Jackson Goth
 *
 */

public class QuickTurn extends CommandBase {
>>>>>>> origin/master

public class QuickTurn extends CommandBase {
	AHRS ahrs = new AHRS(Port.kMXP); //This is wrong but whatever
	final double speed;
	final double time;
	private final Timer timer;
	boolean left;
	
	/**
	 * Makes the robot turn about 90 degrees
	 * @param left
	 * 		if it should turn left or right. (T or F)
	 */
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
	return false;
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
