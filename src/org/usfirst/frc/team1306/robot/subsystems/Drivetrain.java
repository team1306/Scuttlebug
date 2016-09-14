package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the motors with the joysticks from oi
 * @author Sam Roquitte
 *
 */

public class Drivetrain extends Subsystem {
	private final CANTalon[] motors;	
	private final CANTalon leftmotor1, leftmotor2;
	private final CANTalon rightmotor1, rightmotor2;
	
	public Drivetrain() {
		leftmotor1 = new CANTalon(RobotMap.LEFT_TALON_1_PORT);
		leftmotor2 = new CANTalon(RobotMap.LEFT_TALON_2_PORT);
		rightmotor1 = new CANTalon(RobotMap.RIGHT_TALON_1_PORT);
		rightmotor2 = new CANTalon(RobotMap.RIGHT_TALON_2_PORT);
		motors = new CANTalon[] {leftmotor1, leftmotor2, rightmotor1, rightmotor2};
	}
	
	/**
	 * Takes 2 params to control the motors
	 * 
	 * @param leftVal
	 * 		Speed for the left side (from -1 to 1)
	 * @param rightVal
	 * 		Speed for the right side (from -1 to 1)
	 */
	
	public void tankDrive(double leftVal, double rightVal) {
		leftmotor1.changeControlMode(TalonControlMode.PercentVbus);
		rightmotor1.changeControlMode(TalonControlMode.PercentVbus);
		leftmotor1.set(-leftVal);
		rightmotor1.set(rightVal);
	}
	
	/**
	 * Sets the motor speed to 0
	 * 
	 * @param motor
	 * 		The motor that you would like to stop 0,1,2,3:(left1, left2, right1, right2)
	 */
	
	public void stopMotor(int motor) {
		motors[motor].set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}