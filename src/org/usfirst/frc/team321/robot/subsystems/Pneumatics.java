package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.RegulateCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	public DoubleSolenoid gearShiftSolenoid;
    public DoubleSolenoid rightDoubleSolenoid;
    public Compressor compressor;

	public Pneumatics() {
		gearShiftSolenoid = new DoubleSolenoid(4, 5);
		
		
		compressor = new Compressor(RobotMap.COMPRESSOR);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new RegulateCompressor());
    }    
    
    public Value getGear(){
    	//Left solenoid is the one that determines the gear, since the right gear is inverted.
    	return gearShiftSolenoid.get();
    }
    
    public DoubleSolenoid getLeftDoubleSolenoid() {
		return gearShiftSolenoid;
	}

	public void setLeftDoubleSolenoid(DoubleSolenoid val) {
		gearShiftSolenoid = val;
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
	
	public boolean isCompressorSafeToUse(){	
		if((compressor.getCompressorCurrentTooHighFault() && !compressor.getCompressorCurrentTooHighStickyFault()) ||
  			(compressor.getCompressorNotConnectedFault() && !compressor.getCompressorNotConnectedStickyFault()) || 
  			(compressor.getCompressorShortedFault() && !compressor.getCompressorShortedStickyFault())){
			return false;
	   	}else{
	   		return true;
		}
	}	
	
	public boolean getPressure(){
		return compressor.getPressureSwitchValue();
	}
}