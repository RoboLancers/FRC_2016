package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Henry Dang
 */
public class AutoMoveThroughChevalDeFrise extends Command {

	
    boolean distanceLessThanDistanceToChevalDeFrise = false;
    boolean hasFinished = false;
	
    //Go to game manual and find distance IN METERS!!! METERS!
    //Distance is in meters now!!!
    public final double DISTANCE = 2.18;
	public final double DIAMETER = 0.254;
    double rotationsRequired = DISTANCE/DIAMETER;
	double encoderTicksRequired = rotationsRequired * Robot.driveTrain.TICKS_PER_ROTATION;
	
    long currentTime = 0;
    
	public AutoMoveThroughChevalDeFrise() {
		requires(Robot.driveTrain);
    }

    protected void initialize() {
    	hasFinished = false;
    	distanceLessThanDistanceToChevalDeFrise = false;
    	currentTime = System.currentTimeMillis();
    }

    protected boolean isAtChevalDeFrise(){
    	//TODO: this method name is bad and it lies
    	if(distanceLessThanDistanceToChevalDeFrise == true 
    			|| (System.currentTimeMillis() - currentTime < 15000)){
    		return true;
    	}
    	
    	if(Robot.driveTrain.encoder_L.get() > encoderTicksRequired){
    		distanceLessThanDistanceToChevalDeFrise = true;
    	}
    	return false;
    }
    
    protected void execute() {
    	
    	while(!isAtChevalDeFrise()){
    		Robot.driveTrain.setAllPowers(0.5);
    	}
    	
    	//Is this even legal? I don't think it is. Might be better to use a CommandGroup
    	new LowerManipulator().execute();
    	
    	//Hop over the cheval de frise now
    	while(System.currentTimeMillis() - currentTime < 15000){
    		Robot.driveTrain.setAllPowers(1.0);
    	}
    	
    	//Program done.
    	hasFinished = true;
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
    	Robot.driveTrain.setAllPowers(0);
    	Robot.intakePivot.setPivotMotor(0);
    }

    protected void interrupted() {
    	Robot.driveTrain.setAllPowers(0);
    	Robot.intakePivot.setPivotMotor(0);
    	hasFinished = true;
    }
}
