package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * Controls the motors with the joysticks from oi
 * @author Sam Roquitte
 *
 */

public class Drivetrain {	
	private final CANTalon leftmotor1, leftmotor2;
	private final CANTalon rightmotor1, rightmotor2;
	
	public Drivetrain() {
		leftmotor1 = new CANTalon(RobotMap.LEFT_TALON_1_PORT);
		leftmotor2 = new CANTalon(RobotMap.LEFT_TALON_2_PORT);
		rightmotor1 = new CANTalon(RobotMap.RIGHT_TALON_1_PORT);
		rightmotor2 = new CANTalon(RobotMap.RIGHT_TALON_2_PORT);
	}
	
	/**
	 * Takes 2 params to control the motors
	 * 
	 * @param leftVal
	 * 		Speed for the left side
	 * @param rightVal
	 * 		Speed for the right side
	 */
	
	public void tankDrive(double leftVal, double rightVal) {
		leftmotor1.changeControlMode(TalonControlMode.PercentVbus);
		rightmotor1.changeControlMode(TalonControlMode.PercentVbus);
		leftmotor1.set(-leftVal);
		rightmotor1.set(rightVal);
	}
}