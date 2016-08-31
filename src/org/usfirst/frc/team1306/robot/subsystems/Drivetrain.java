package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * Controls the motors with the joysticks from oi
 * @author Sam
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
}