package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class UseIntake extends Command {

	int direction;
	boolean hasFinished;
	
    public UseIntake(int direction) {
    	requires(Robot.intake);
    	
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!OI.maniBtn[0].get() && direction == Intake.INTAKE){
    		hasFinished = true;
    	}else if(!OI.maniBtn[1].get() && direction == Intake.OUTTAKE){
    		hasFinished = true;
    	}
    	
    	if(direction == Intake.INTAKE){
    		useIntake(Intake.INTAKE);
    	}else {
    		useIntake(Intake.OUTTAKE);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	useIntake(Intake.STOP);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public void useIntake(double power){
    	Robot.intake.setIntakeMotor(power);
    }
}
