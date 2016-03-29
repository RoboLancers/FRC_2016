package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.LancerPID;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousMoveThroughDefense extends Command {

	//Numbers are in meters
	//gear ratio is 56:1
	//public final double DISTANCE = 3.0;
	//public final double DIAMETER = 0.254;
	
	private LancerPID autoPID;
	private LancerPID autoPID_R;
	
	private long time;
	
	private boolean hasFinished;
	private boolean firstPass;

    public AutonomousMoveThroughDefense() {
    	requires(Robot.driveTrain);
    	
    	hasFinished=false;
    	firstPass = true;
    	
    	autoPID = new LancerPID(.1,0,.05);
    	//double rotationsRequired = DISTANCE/DIAMETER;
    	//double encoderTicksRequired = rotationsRequired * Robot.driveTrain.TICKS_PER_ROTATION;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(firstPass){
    		time = System.currentTimeMillis();	
    		firstPass = false;
    		
    		//Robot.driveTrain.setLeftPowers(.5);
    		//Robot.driveTrain.setRightPowers(.5);
    	}else{
    		//Robot.driveTrain.setLeftPowers(-1);
    		//Robot.driveTrain.setRightPowers(1);
	    	autoPID.setReference(Robot.driveTrain.navX.getYaw());
	    	
	    	if(System.currentTimeMillis() - time < 6000){
	    		Robot.driveTrain.setLeftPowers(.5+autoPID.calcPID(Robot.driveTrain.navX.getYaw()));
	    		Robot.driveTrain.setRightPowers(.5-autoPID.calcPID(Robot.driveTrain.navX.getYaw()));
	    		
	    	}else{hasFinished = true;}
    	
    		//if(System.currentTimeMillis()-time >6000){
    		//	hasFinished = true;
    		//}
    	}
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
    	Robot.driveTrain.setAllPowers(0);
    }

    protected void interrupted() {
    	Robot.driveTrain.setAllPowers(0);
    }
}
