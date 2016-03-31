package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerManipulator extends Command {

	boolean hasFinished = false;
	
    public LowerManipulator() {
    	requires(Robot.intakePivot);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	hasFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentTime = System.currentTimeMillis();
    	
    	while(System.currentTimeMillis() - currentTime < 1000){
        	Robot.intakePivot.setPivotMotor(-1);
    	}
    	
    	Robot.intakePivot.setPivotMotor(0);
    	hasFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakePivot.setPivotMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intakePivot.setPivotMotor(0);
    	hasFinished = true;
    }
}
