package org.usfirst.frc.team1306.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardUpdate extends CommandBase {

	@Override
	protected void initialize() {
		SmartDashboard.putString("SmartDashboard Initialized!!!!!!!", "it works?");
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
