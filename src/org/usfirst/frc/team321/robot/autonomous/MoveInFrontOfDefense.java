package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.TimeTracker;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Henry Dang
 *
 */
public class MoveInFrontOfDefense extends Command {

    private final double DISTANCE = 2.18;
	private final double DIAMETER = 0.254;
	
	private boolean hasFinished = false;
	
    private double rotationsRequired = DISTANCE/DIAMETER;
	private double encoderTicksRequired = rotationsRequired * 
			Robot.driveTrain.TICKS_PER_ROTATION;
	
	private Encoder encoder_L;
	private Encoder encoder_R;
	private TimeTracker timeTracker;
	
    public MoveInFrontOfDefense(TimeTracker timeTracker, 
    		Encoder encoder_L, Encoder encoder_R) {
    	requires(Robot.driveTrain);
    	this.encoder_L = encoder_L;
    	this.encoder_R = encoder_R;
    	this.timeTracker = timeTracker;
    }

    protected void initialize() {
    	hasFinished = false;
    }

    protected void execute() {
    	while(hasNotReachedDefense() && !timeTracker.hasEnded()) {
    		Robot.driveTrain.setAllPowers(0.5);
    	}
    	
    	hasFinished = true;
    }
    
    private boolean hasNotReachedDefense(){
    	if(encoder_L.get() <= encoderTicksRequired && 
    			encoder_R.get() <= encoderTicksRequired){
    		return true;
    	}
    	return false;
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
    	Robot.driveTrain.setAllPowers(0);
    }

    protected void interrupted() {
    	hasFinished = true;
    	Robot.driveTrain.setAllPowers(0);
    }
}
