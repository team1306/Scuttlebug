package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hood extends Subsystem {
	private final CANTalon hoodTalon;
	
	public Hood() {
		hoodTalon = new CANTalon(RobotMap.HOOD_TALON_PORT);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
