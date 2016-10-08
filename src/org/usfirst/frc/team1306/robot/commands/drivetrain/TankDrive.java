package org.usfirst.frc.team1306.robot.commands.drivetrain;

import org.usfirst.frc.team1306.robot.OI.*;
import org.usfirst.frc.team1306.robot.commands.CommandBase;

public class TankDrive extends CommandBase {
	
	public TankDrive() {
		requires(drivetrain);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		
		drivetrain.tankDrive(oi.getTriggerVal(controller.p, trigger.r), oi.getTriggerVal(controller.p, trigger.l));
		drivetrain.tankDrive(oi.getRightJoyVal(controller.p, axis.y), oi.getLeftJoyVal(controller.p, axis.y));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.stopAll();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}