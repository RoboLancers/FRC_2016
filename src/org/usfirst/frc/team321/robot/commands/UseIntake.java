package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.Intake.IntakeValues;

import edu.wpi.first.wpilibj.command.Command;

public class UseIntake extends Command {

	boolean hasFinished;
	//Intake.IntakeValues, but it's imported.
	IntakeValues intakeValue;
	
    public UseIntake(IntakeValues intakeValue) {
    	requires(Robot.intake);
    	
    	this.intakeValue = intakeValue;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!OI.maniBtn[0].get() && intakeValue == IntakeValues.INTAKE){
    		hasFinished = true;
    	}else if(!OI.maniBtn[1].get() && intakeValue == IntakeValues.OUTTAKE){
    		hasFinished = true;
    	}
    	
    	if(intakeValue == IntakeValues.INTAKE){
    		useIntake(IntakeValues.INTAKE.getValue());
    	}else {
    		useIntake(IntakeValues.OUTTAKE.getValue());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	useIntake(IntakeValues.STOP.getValue());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public void useIntake(double power){
    	Robot.intake.setIntakeMotor(power);
    }
}
