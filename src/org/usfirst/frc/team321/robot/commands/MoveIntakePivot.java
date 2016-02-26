package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.IntakePivot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntakePivot extends Command {

	private boolean hasFinished = false;
	private double power;
	private IntakePivot intakePivot;
	
    public MoveIntakePivot() {
        requires(Robot.intakePivot);
        this.intakePivot = Robot.intakePivot;
    }
    
    protected void initialize() {
    	//unlock the motor first
    	hasFinished = false;
    	intakePivot.unlockPivotMotor();
    }

    protected void execute() {
    	if(OI.driveStick.getRawAxis(2)>.1){
    		intakePivot.setPivotMotor(OI.driveStick.getRawAxis(2)/2);
    	}
    	if(OI.driveStick.getRawAxis(3)>.1){
    		intakePivot.setPivotMotor(-OI.driveStick.getRawAxis(3)/2);
    	}
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
    	intakePivot.setPivotMotor(0);
    	intakePivot.lockPivotMotor();
    }

    protected void interrupted() {
    	hasFinished = true;
    	intakePivot.setPivotMotor(0);
    	intakePivot.lockPivotMotor();
    }
}
