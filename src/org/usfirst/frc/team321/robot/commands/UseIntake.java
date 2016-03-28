package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.Intake.IntakeValues;

import edu.wpi.first.wpilibj.command.Command;

public class UseIntake extends Command {

	private boolean hasFinished;
	private IntakeValues intakeValue;
	
    public UseIntake(IntakeValues intakeValue) {
    	requires(Robot.intake);
    	
       	this.intakeValue = intakeValue;
    }

    protected void initialize() {
    	hasFinished = false;
    }

    public void useIntake(double power){
    	Robot.intake.setIntakeMotor(.75*power);
    }
        
    protected void execute() {	
    	if(intakeValue == IntakeValues.INTAKE){
    		useIntake(IntakeValues.INTAKE.getValue());
    	}else {
    		useIntake(IntakeValues.OUTTAKE.getValue());
    	}
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
    	useIntake(IntakeValues.STOP.getValue());
    }

    protected void interrupted() {
    	useIntake(IntakeValues.STOP.getValue());
    	hasFinished = true;
    }
}
