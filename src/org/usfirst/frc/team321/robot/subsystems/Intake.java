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
	
    public static final int OUTTAKE = -1;
	public static final int INTAKE = 1;
	public static final int STOP = 0;
	
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

