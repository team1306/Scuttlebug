package org.usfirst.frc.team1306.robot.commands;


import org.usfirst.frc.team1306.robot.Constants;


import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * 
 * Quickly turns to a certain degree measure
 * 
 * @author Sam Roquitte Amit Rajesh Jackson Goth
 *
 */

public class SmartQuickTurn extends CommandBase {
	final double speed = 0;
	final double degree = 0;
	boolean done;
	AHRS ahrs = new AHRS(Port.kMXP);
	double left_turn, right_turn;
	
	public SmartQuickTurn(double degree) {
		requires(drivetrain);
		
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		ahrs = new AHRS(Port.kMXP);
		double current_angle;
		double angle_difference;
		done = false;
		 left_turn= 0.5;
		 right_turn=0.5;

		while(done == false) {
			current_angle = ahrs.getAngle();
			angle_difference = current_angle - degree;
			if(angle_difference < 1 && angle_difference > -1) {
				done = true;
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

			
		}
		drivetrain.tankDrive(left_turn, right_turn);
	}

	@Override
	protected boolean isFinished() {
		return done;
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
