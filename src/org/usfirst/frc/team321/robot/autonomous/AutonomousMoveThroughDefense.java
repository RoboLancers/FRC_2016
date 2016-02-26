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

    protected void initialize() {    	
    }

    protected void execute() {
    	double rotationsRequired = DISTANCE/DIAMETER;
    	double encoderTicksRequired = rotationsRequired * Robot.driveTrain.TICKS_PER_ROTATION;
    	
    	while (encoder.get() <= encoderTicksRequired) {
    		Robot.driveTrain.setAllPowers(0.5);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
