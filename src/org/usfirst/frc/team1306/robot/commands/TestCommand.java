package org.usfirst.frc.team1306.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1306.robot.Robot;

/**
 * A basic command used to learn how commands work
 * 
 * @author Sam Roquitte
 *
 */

public class TestCommand extends Command {
	
	int i = 0;
	
	public TestCommand() {
		System.out.println("Test Command!");
	}

	protected void end() {
		System.out.println("Ended");
	}

	protected void execute() {
		i++;
	}

	protected void initialize() {
		System.out.println("Test Command Starting up!");
	}

	protected void interrupted() {
		System.out.println("We were interupted!");
	}

	protected boolean isFinished() {
		if (i > 1000) {
			return true;
		}
		else {
			return false;
		}
	}

}
