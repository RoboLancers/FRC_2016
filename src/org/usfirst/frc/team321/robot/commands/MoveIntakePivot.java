package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.IntakePivot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntakePivot extends Command {

	boolean hasFinished = false;
	double power;
	IntakePivot intakePivot;
	
    public MoveIntakePivot() {
        requires(Robot.intakePivot);
        this.intakePivot = Robot.intakePivot;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	//unlock the motor first
    	hasFinished = false;
    	intakePivot.unlockPivotMotor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.driveStick.getRawAxis(2)>.1){
    		intakePivot.setPivotMotor(OI.driveStick.getRawAxis(2)/2);
    	}
    	if(OI.driveStick.getRawAxis(3)>.1){
    		intakePivot.setPivotMotor(-OI.driveStick.getRawAxis(3)/2);
    	}
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intakePivot.setPivotMotor(0);
    	intakePivot.lockPivotMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	hasFinished = true;
    	intakePivot.setPivotMotor(0);
    	intakePivot.lockPivotMotor();
    }
}
