package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private SpeedController intakeMotor;
	public Encoder pivotEncoder;
		
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
	
	public Intake(){
		intakeMotor = new Talon(RobotMap.INTAKE);
	}
	
    public void initDefaultCommand() {
    }

	public void setIntakeMotor(double power) {
		if(Math.abs(power) <= 1){
			intakeMotor.set(power); 
		}
	}
}