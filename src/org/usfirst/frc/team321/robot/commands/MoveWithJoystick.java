package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.joystick_controller_types.JoystickControllerType;
import org.usfirst.frc.team321.joystick_controller_types.TankDrive;
import org.usfirst.frc.team321.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWithJoystick extends Command {
	
	private JoystickControllerType joystickControllerType;
	
    public MoveWithJoystick() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setJoystickControllerType(new TankDrive());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	joystickControllerType.drive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected void setJoystickControllerType(JoystickControllerType type){
    	this.joystickControllerType = type;
    }
}
