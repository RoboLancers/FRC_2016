package org.usfirst.frc.team321.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	Compressor compressor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean isCompressorSafeToUse(){	
    	if((compressor.getCompressorCurrentTooHighFault() && !compressor.getCompressorCurrentTooHighStickyFault()) ||
   			(compressor.getCompressorNotConnectedFault() && !compressor.getCompressorNotConnectedStickyFault()) || 
   			(compressor.getCompressorShortedFault() && !compressor.getCompressorShortedStickyFault())){
    		return false;
    	}else{
    		return true;
    	}
    }
    	
    public double getPressure(){
    	return compressor.getCompressorCurrent();
    }
    
    public void regulateCompressor(){
    	if(!compressor.getPressureSwitchValue() && !compressor.enabled()
    			&& isCompressorSafeToUse()){
    		compressor.start();
    	}else if(compressor.getPressureSwitchValue() && compressor.enabled() 
    			|| !isCompressorSafeToUse()){
    		compressor.stop();
    	}
    }
}

