package org.usfirst.frc.team1306.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1306.robot.Robot;

/**
 * This class is used to experiment with commands and the methods within them...
 * -
 * @author Jackson Goth
 *
 */

public class somethingNotTestCommandButSomethingElse extends Command {

	int i;
	
	public somethingNotTestCommandButSomethingElse() {
		
		
	}
	
	protected void end() {
		
		// Called once after isFinished returns true
		
		System.out.println("End Code Working");
	}
	
	protected void execute() {
		
		// Called repeatedly when this Command is scheduled to run
		
		i++;
		
		System.out.println("Execution Code Working");
	}

	protected void initialize() {
		
		// Called just before this Command runs the first time
		
		i = 0;
		
		System.out.println("Initialization Code Working");
	}

	protected void interrupted() {
		
		// Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
		
		System.out.println("Interrupted Code Working");
	}
	
	protected boolean isFinished() {
		
		// Make this return true when this Command no longer needs to run execute()
		
		if(i >= 10) {
			return true;
		}
		
		System.out.println("isFinished Code Working");
		return false;
	}

	
}
