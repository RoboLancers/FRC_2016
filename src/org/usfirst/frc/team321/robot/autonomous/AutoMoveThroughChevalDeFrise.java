package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.TimeTracker;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMoveThroughChevalDeFrise extends CommandGroup {
   
	private final long autonomousLength = 15000;
	private TimeTracker timeTracker;
	
    public  AutoMoveThroughChevalDeFrise() {
    	timeTracker = new TimeTracker(autonomousLength);
    	
    	addSequential(new MoveInFrontOfDefense(timeTracker, Robot.driveTrain.encoder_L,
    			Robot.driveTrain.encoder_R));
    	
    	addSequential(new LowerManipulator());
    	
    	addSequential(new AutoDriveForward(timeTracker));
    }
}