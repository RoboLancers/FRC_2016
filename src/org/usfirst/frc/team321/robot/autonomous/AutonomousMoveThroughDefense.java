package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousMoveThroughDefense extends Command {

	//Numbers are in meters
	//56:1
	public final double DISTANCE = 3.5;
	public final double DIAMETER = 0.254;

	Encoder encoder;
		
    public AutonomousMoveThroughDefense(Encoder encoder) {
    	requires(Robot.driveTrain);
    	
    	//Only requires one encoder because values for both encoders
    	//are approximately the same if robot moves straight forward
    	this.encoder = encoder;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rotationsRequired = DISTANCE/DIAMETER;
    	double encoderTicksRequired = rotationsRequired * Robot.driveTrain.TICKS_PER_ROTATION;
    	
    	while (encoder.get() <= encoderTicksRequired) {
    		Robot.driveTrain.setAllPowers(0.5);
    	}
    	//TODO: With EncoderTicksRequired, check for number of current encoder ticks to be less than 
    	//TODO: encoderTicksRequired, and when it is greater, stop, cause you crossed 3.5 meters.
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
