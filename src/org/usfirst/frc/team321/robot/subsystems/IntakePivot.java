package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveIntakePivot;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakePivot extends Subsystem {

	public CANTalon pivotMotor;
	private double lastPower;
	private boolean isFirstPass;
	public Encoder pivotEncoder;
	
	public IntakePivot(){
		pivotMotor = new CANTalon(RobotMap.INTAKE_PIVOT);
		pivotMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		pivotMotor.setEncPosition(0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveIntakePivot());
    	
    	isFirstPass=true;
    }
	
	public void setPivotMotor(double power){
		if(isFirstPass == false){
			
			if(Math.abs(power) <= 1){
				pivotMotor.set(/*lastPower+.8*(power-lastPower)*/ power);
				lastPower=power;
			}else{
				throw new MotorValueOutOfBoundsException();
			}
		}else{
			lastPower=power;
			isFirstPass=false;
		}
	}
	
	public void lockPivotMotor(){
		pivotMotor.enableBrakeMode(true);
	}
	
	public void unlockPivotMotor(){
		pivotMotor.enableBrakeMode(false);
	}
    
	public boolean isPivotMotorLocked(){
		return pivotMotor.getBrakeEnableDuringNeutral();
	}
}

