package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	public enum IntakeValues {
		OUTTAKE(-1.0), INTAKE(1.0), STOP(0);
		
		private double value;
		
		private IntakeValues(double value){
			this.value = value;
		}
		
		public double getValue(){
			return value;
		}
	}
   
	private SpeedController intakeMotor;
	
	public Intake(){
		intakeMotor = new Talon(RobotMap.INTAKE);
	}
	
    public void initDefaultCommand() {
    }

	public void setIntakeMotor(double power) {
		if(Math.abs(power) <= 1){
			intakeMotor.set(power); 
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
}

