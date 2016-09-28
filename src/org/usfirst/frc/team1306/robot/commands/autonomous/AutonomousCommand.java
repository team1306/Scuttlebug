package org.usfirst.frc.team1306.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup{

	public AutonomousCommand(Direction direction) {
		
		addSequential(direction.getDriveCommand());
	}
}
