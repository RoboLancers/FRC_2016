package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.TimeTracker;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveForward extends Command {

	private TimeTracker timeTracker;
	private boolean hasFinished = false;
	
    public AutoDriveForward(TimeTracker timeTracker) {
    	requires(Robot.driveTrain);
    	this.timeTracker = timeTracker;
    }

    protected void initialize() {
    	hasFinished = false;
    }

    protected void execute() {
    	while(!timeTracker.hasEnded()){
    		Robot.driveTrain.setAllPowers(1.0);
    	}
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