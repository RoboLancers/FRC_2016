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
    
	public DoubleSolenoid leftDoubleSolenoid;
    public DoubleSolenoid rightDoubleSolenoid;
    public Compressor compressor;

	public Pneumatics() {
		leftDoubleSolenoid = new DoubleSolenoid(4, 5);
		rightDoubleSolenoid = new DoubleSolenoid(6, 7);
		
		compressor = new Compressor(RobotMap.COMPRESSOR);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new RegulateCompressor());
    }    
    
    public Value getGear(){
    	//Left solenoid is the one that determines the gear, since the right gear is inverted.
    	return leftDoubleSolenoid.get();
    }
    
    public DoubleSolenoid getLeftDoubleSolenoid() {
		return leftDoubleSolenoid;
	}

	public void setLeftDoubleSolenoid(DoubleSolenoid leftDoubleSolenoid) {
		this.leftDoubleSolenoid = leftDoubleSolenoid;
	}

	public DoubleSolenoid getRightDoubleSolenoid() {
		return rightDoubleSolenoid;
	}

	public void setRightDoubleSolenoid(DoubleSolenoid rightDoubleSolenoid) {
		this.rightDoubleSolenoid = rightDoubleSolenoid;
	}
	public void regulateCompressor(){
		/*
		boolean isError = false;
		
		//Error Regulations
		if((compressor.getCompressorCurrentTooHighFault() && !compressor.getCompressorCurrentTooHighStickyFault()) ||
				(compressor.getCompressorNotConnectedFault() && !compressor.getCompressorNotConnectedStickyFault()) ||
				(compressor.getCompressorShortedFault() && !compressor.getCompressorShortedStickyFault()))
		{
			//isError = true;
		}else{
			//isError = false; 
		}

		if(!compressor.getPressureSwitchValue() && !compressor.enabled() && !isError){
			compressor.start();
		}
		else if((compressor.getPressureSwitchValue() && compressor.enabled()) || isError){
			compressor.stop();
		}*/
		
		compressor.start();
	}
	
	public boolean getPressure(){
		return compressor.getPressureSwitchValue();
	}
	
}

