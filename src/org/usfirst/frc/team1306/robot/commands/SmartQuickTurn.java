package org.usfirst.frc.team1306.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * To turn robot to any given degree automatically
 * 
 * @author Jackson Goth and Amit Rajesh
 *
 */

public class SmartQuickTurn extends CommandBase {

	double newDegree;
	boolean isDoneTurning;
	AHRS ahrs = new AHRS(Port.kMXP);
	
	public SmartQuickTurn(double degree) {
		requires(drivetrain);
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
