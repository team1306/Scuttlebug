package org.usfirst.frc.team1306.robot.commands;

<<<<<<< HEAD
=======

import org.usfirst.frc.team1306.robot.Constants;


>>>>>>> origin/master
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * To turn robot to any given degree automatically
 * 
<<<<<<< HEAD
 * @author Jackson Goth and Amit Rajesh
=======
 * Quickly turns to a certain degree measure
 * 
 * @author Sam Roquitte Amit Rajesh Jackson Goth
>>>>>>> origin/master
 *
 */

public class SmartQuickTurn extends CommandBase {
<<<<<<< HEAD

	double newDegree;
	boolean isDoneTurning;
=======
	final double speed = 0;
	final double degree = 0;
	boolean done;
>>>>>>> origin/master
	AHRS ahrs = new AHRS(Port.kMXP);
	double left_turn, right_turn;
	
	public SmartQuickTurn(double degree) {
		requires(drivetrain);
<<<<<<< HEAD
		newDegree = degree;
		ahrs = new AHRS(Port.kMXP);
	}
	
	@Override
	protected void initialize() {
		isDoneTurning = false;
	}

	@Override
	protected void execute() {
		double current_angle = ahrs.getAngle();
		double angle_difference = current_angle - newDegree;
		double left_turn = 0.0;
		double right_turn = 0.0;
		
		if(angle_difference < 1 && angle_difference > -1) {
			isDoneTurning = true;
		} else if(angle_difference <= -1) {
			left_turn = -0.5;
			right_turn = 0.5;
		} else if(angle_difference >= 1) {
			left_turn = 0.5;
			right_turn = -0.5;				
		}
		
		SmartDashboard.putNumber("Current Angle: ", current_angle);
		SmartDashboard.putNumber("Degree: ", newDegree);
		SmartDashboard.putNumber("AngleDifference: ", current_angle);
		SmartDashboard.putNumber("Left_Turn: ", left_turn);
		SmartDashboard.putNumber("Right_Turn: ", right_turn);
		drivetrain.tankDrive(left_turn, right_turn);
		
=======
		
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
>>>>>>> origin/master
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
