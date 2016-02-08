package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	public enum IntakeValues {
		OUTTAKE(-1), INTAKE(1), STOP(0);
		
		private int value;
		
		private IntakeValues(int value){
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
	}
   
	private SpeedController intakeMotor;
	private static Intake intake;
	
	private Intake(){
		intakeMotor = new CANTalon(RobotMap.INTAKE);
	}
	
	public static Intake getInstance(){
		if(null == intake){
			intake = new Intake();
		}
		return intake;
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
    
}

