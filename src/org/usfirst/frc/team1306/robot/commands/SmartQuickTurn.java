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
	AHRS ahrs= new AHRS(Port.kMXP);
	
	public SmartQuickTurn(boolean left, double degree) {
		requires(drivetrain);
		ahrs= new AHRS(Port.kMXP);
		double current_angle=ahrs.getAngle();
		double angle_difference=current_angle-degree;
		int done=0;

		while (done==0) {
			if (angle_difference == 0) {
				done=1;
			}
			if (angle_difference < 0) {
				drivetrain.tankDrive(-0.5, 0.5);
			}
			else {
				drivetrain.tankDrive(0.5,-0.5);
				
			}
		

			
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
