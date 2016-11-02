package org.usfirst.frc.team1306.robot.commands;


import org.usfirst.frc.team1306.robot.Constants;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;

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
	AHRS ahrs = new AHRS(Port.kMXP);
	
	public SmartQuickTurn(double degree) {
		requires(drivetrain);
		ahrs = new AHRS(Port.kMXP);
		double current_angle = ahrs.getAngle();
		double angle_difference = current_angle - degree;
		int done = 0;
		double left_turn= 0.5;
		double right_turn=0.5;

		while(done == 0) {
			current_angle = ahrs.getAngle();
			angle_difference = current_angle - degree;
			if(angle_difference < 1 && angle_difference > -1) {
				done = 1;
				break;
			}
			if(angle_difference < -1) {
				left_turn=-0.5;
				right_turn=0.5;

			}
			else {
				left_turn=0.5;
				right_turn=-0.5;				
			}

			
			drivetrain.tankDrive(left_turn, right_turn);
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
