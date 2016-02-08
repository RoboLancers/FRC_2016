package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.utilities.JoystickUtil;
import org.usfirst.frc.team321.utilities.RobotUtil;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWithJoystick extends Command {
	
	//private JoystickControllerType joystickControllerType;
	boolean rcDrive = false;
	
    public MoveWithJoystick() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(rcDrive){
    		double[] motorValues = JoystickUtil.arcadeDrive(JoystickUtil.getLeftYAxisValue(),
    				JoystickUtil.getRightXAxisValue(), true);
    		
    		DriveTrain.setLeftPowers(motorValues[0]);
    		DriveTrain.setRightPowers(motorValues[1]);
    	}else{
    		DriveTrain.setLeftPowers(RobotUtil.squareAndKeepSign(JoystickUtil.getLeftYAxisValue()));
       		DriveTrain.setRightPowers(RobotUtil.squareAndKeepSign(JoystickUtil.getRightYAxisValue()));
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
