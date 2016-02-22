package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	public enum IntakeValues {
		OUTTAKE(-0.3), INTAKE(0.3), STOP(0);
		
		private double value;
		
		private IntakeValues(double value){
			this.value = value;
		}
		
		public double getValue(){
			return value;
		}
	}
	
	public enum IntakePivotValues {
		UPWARDS(-0.3), DOWNWARDS(0.3), STOP(0);
		
		private double value;
		
		private IntakePivotValues(double value){
			this.value = value;
		}
		
		public double getValue(){
			return value;
		}
	}
   
	private SpeedController intakeMotor;
	private CANTalon pivotMotor;
	
	public Intake(){
		intakeMotor = new Talon(RobotMap.INTAKE);
		pivotMotor = new CANTalon(RobotMap.INTAKE_PIVOT);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void setIntakeMotor(double power) {
		if(Math.abs(power) <= 1){
			intakeMotor.set(power); 
		}else{
			throw new MotorValueOutOfBoundsException();
		}
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
    
}

