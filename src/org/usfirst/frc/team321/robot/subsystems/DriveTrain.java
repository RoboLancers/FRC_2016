package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveWithJoystick;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
	private static DriveTrain driveTrain;
	private static SpeedController leftFront, leftBack, leftMiddle, rightFront, rightMiddle, rightBack;
	
	private DriveTrain(){
    	super("Drive Train");
    	
    	leftFront = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
    	leftMiddle = new CANTalon(RobotMap.LEFT_MIDDLE_MOTOR);
    	leftBack = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
    	rightFront = new CANTalon(RobotMap.LEFT_BACK_MOTOR);
    	rightMiddle = new CANTalon(RobotMap.RIGHT_MIDDLE_MOTOR);
    	rightBack = new CANTalon(RobotMap.RIGHT_BACK_MOTOR);
    	
    }
	
	public static DriveTrain getInstance(){
		if(null == driveTrain){
			driveTrain = new DriveTrain();
		}
		return driveTrain;
	}

    public void initDefaultCommand() {
        setDefaultCommand(new MoveWithJoystick());
    }

	public void setLeftPowers(double power){
		if(Math.abs(power) <= 1){
			leftFront.set(power);
			leftMiddle.set(power);
			leftBack.set(power);
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
	
	public void setRightPowers(double power){
		if(Math.abs(power) <= 1){
			rightFront.set(power);
			rightMiddle.set(power);
			rightBack.set(power);
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
	
	public void setAllPowers(double power){
		setLeftPowers(power);
		setRightPowers(power);
	}
}

