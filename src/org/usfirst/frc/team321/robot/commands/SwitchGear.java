package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchGear extends Command {

	private boolean hasFinished = false;
	private Pneumatics pneumatics;
	
    public SwitchGear() {
    	requires(Robot.pneumatics);
    	this.pneumatics = Robot.pneumatics;
    }

    protected void initialize() {
    }

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

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
