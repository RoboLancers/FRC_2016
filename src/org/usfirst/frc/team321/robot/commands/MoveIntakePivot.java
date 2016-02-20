package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntakePivot extends Command {

	boolean hasFinished = false;
	double power;
	Intake intake;
	
    public MoveIntakePivot(double power) {
        requires(Robot.intake);
        this.intake = Robot.intake;
        this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//unlock the motor first
    	intake.unlockPivotMotor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	intake.setPivotMotor(power);
    	
    	if(!OI.maniBtn[2].get()){
    		hasFinished = true;
    	}else if(!OI.maniBtn[3].get()){
    		hasFinished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.lockPivotMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	hasFinished = true;
    	intake.lockPivotMotor();
    }
}
