package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchGear extends Command {

	boolean hasFinished = false;
	public Pneumatics pneumatics;
	
    public SwitchGear() {
    	requires(Robot.pneumatics);
    	this.pneumatics = Robot.pneumatics;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(pneumatics.leftDoubleSolenoid.get() == DoubleSolenoid.Value.kForward){
    		pneumatics.leftDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    		pneumatics.rightDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    	}else{
    		pneumatics.leftDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    		pneumatics.rightDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    	
    	hasFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
