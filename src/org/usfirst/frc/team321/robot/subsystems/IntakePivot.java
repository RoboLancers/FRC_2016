package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveIntakePivot;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakePivot extends Subsystem {

	private CANTalon pivotMotor;
	
	public IntakePivot(){
		pivotMotor = new CANTalon(RobotMap.INTAKE_PIVOT);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveIntakePivot());
    }
	
	public void setPivotMotor(double power){
		if(Math.abs(power) <= 1){
			pivotMotor.set(power);
		}else{
			throw new MotorValueOutOfBoundsException();
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

