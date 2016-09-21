package org.usfirst.frc.team1306.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1306.robot.commands.TestCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private final XboxController primaryController;
	private final XboxController secondaryController;
	
	private final Button pbuttonA;
	private final Button pbuttonB;
	private final Button pbuttonX;
	private final Button pbuttonY;
	private final Button pbuttonRB;
	private final Button pbuttonLB;
	private final Button pbuttonBack;
	private final Button pbuttonStart;	
	
	private final Button sbuttonA;
	private final Button sbuttonB;
	private final Button sbuttonX;
	private final Button sbuttonY;
	private final Button sbuttonRB;
	private final Button sbuttonLB;
	private final Button sbuttonBack;
	private final Button sbuttonStart;
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public OI() {
		primaryController = new XboxController(RobotMap.PRIMARY_PORT);
		secondaryController = new XboxController(RobotMap.SECONDARY_PORT);
		
		pbuttonA = new JoystickButton(primaryController, XboxController.A);
		pbuttonB = new JoystickButton(primaryController, XboxController.B);
		pbuttonX = new JoystickButton(primaryController, XboxController.X);
		pbuttonY = new JoystickButton(primaryController, XboxController.Y);
		pbuttonRB = new JoystickButton(primaryController, XboxController.RB);
		pbuttonLB = new JoystickButton(primaryController, XboxController.LB);
		pbuttonBack = new JoystickButton(primaryController, XboxController.BACK);
		pbuttonStart = new JoystickButton(primaryController, XboxController.START);
		
		sbuttonA = new JoystickButton(primaryController, XboxController.A);
		sbuttonB = new JoystickButton(primaryController, XboxController.B);
		sbuttonX = new JoystickButton(primaryController, XboxController.X);
		sbuttonY = new JoystickButton(primaryController, XboxController.Y);
		sbuttonRB = new JoystickButton(primaryController, XboxController.RB);
		sbuttonLB = new JoystickButton(primaryController, XboxController.LB);
		sbuttonBack = new JoystickButton(primaryController, XboxController.BACK);
		sbuttonStart = new JoystickButton(primaryController, XboxController.START);
		
		pbuttonA.whenPressed(new TestCommand());
		
		//pbuttonA.whenPressed(new commandName());

	}
	
	/*
	 * Returns y axis value of right joystick put the a changeable multiplier for increased or decreased sensitivity with a deadband
	 */
	public double getRightVel() {
		return Math.pow(deadband(primaryController.getY(Hand.kRight)), Constants.JOYSTICK_MULTIPLIER);
	}
	
	/*
	 * Returns y axis value of left joystick put the a changeable multiplier for increased or decreased sensitivity with a deadband
	 */
	public double getLeftVel() {
		return Math.pow(deadband(primaryController.getY(Hand.kLeft)), Constants.JOYSTICK_MULTIPLIER);
	}
	
	/*
	 * Applies deadband to joystick values to prevent false readings when joystick is idle.  It prevents very small changes to 
	 * an idle joystick to trigger anything.
	 */
	private static double deadband(double value) {
		if (value < -Constants.DEADBAND) {
			return (value + Constants.DEADBAND) / (1.0 - Constants.DEADBAND);
		}
		if (value > Constants.DEADBAND) {
			return (value - Constants.DEADBAND) / (1.0 - Constants.DEADBAND);
		}
		return 0;
	}
}

