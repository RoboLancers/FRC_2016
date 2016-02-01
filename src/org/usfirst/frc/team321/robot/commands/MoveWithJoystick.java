package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.utilities.JoystickUtil;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWithJoystick extends Command {
	
	//private JoystickControllerType joystickControllerType;
	boolean rcDrive = true;
	
    public MoveWithJoystick() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	if(rcDrive){
    		if(Math.abs(JoystickUtil.getLeftYAxisValue()) > 0){
    			DriveTrain.setAllPowers(JoystickUtil.getLeftYAxisValue());
    		}else{
    			DriveTrain.setLeftPowers(JoystickUtil.getRightXAxisValue());
    			DriveTrain.setRightPowers(JoystickUtil.getRightXAxisValue());
    		}
    	}else{
    		DriveTrain.setLeftPowers(JoystickUtil.getLeftYAxisValue());
	    	DriveTrain.setRightPowers(JoystickUtil.getRightYAxisValue());
	    }
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
}
