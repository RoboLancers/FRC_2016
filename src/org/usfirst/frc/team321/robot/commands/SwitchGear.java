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
    	if(pneumatics.gearShiftSolenoid.get() == DoubleSolenoid.Value.kForward){
    		pneumatics.gearShiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    	}else{
    		pneumatics.gearShiftSolenoid.set(DoubleSolenoid.Value.kForward);
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
