package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveWithJoystick;
import org.usfirst.frc.team321.utilities.LancerPID;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
	private static DriveTrain driveTrain;
	public static SpeedController leftFront, leftBack, leftMiddle, rightFront, rightMiddle, rightBack;
	public static final int TICKS_PER_ROTATION = 1420;
	public static LancerPID PID_R,PID_L;
	public static Encoder encoder_L,encoder_R; 
	
	private DriveTrain(){
    	super("Drive Train");
    	
    	leftFront = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
    	leftMiddle = new CANTalon(RobotMap.LEFT_MIDDLE_MOTOR);
    	leftBack = new CANTalon(RobotMap.LEFT_BACK_MOTOR);
    	rightFront = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
    	rightMiddle = new CANTalon(RobotMap.RIGHT_MIDDLE_MOTOR);
    	rightBack = new CANTalon(RobotMap.RIGHT_BACK_MOTOR);
    	
    	PID_R = new LancerPID(1,1,.5,TICKS_PER_ROTATION/36);
    	PID_L = new LancerPID(1,1,.5,TICKS_PER_ROTATION/36);
    	
    	encoder_L = new Encoder(RobotMap.ENC_L_A,RobotMap.ENC_L_B);
    	encoder_R = new Encoder(RobotMap.ENC_R_A,RobotMap.ENC_R_B);
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

	public static void setLeftPowers(double power){
		if(Math.abs(power) <= 1){
			
			PID_L.setReference(power);
			double left = PID_L.calcPID(encoder_L.getRate());
			
			leftFront.set(left);
			leftMiddle.set(left);
			leftBack.set(left);
			
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
	
	public static void setRightPowers(double power){
		if(Math.abs(power) <= 1){
			
			PID_R.setReference(power);
			double right = PID_R.calcPID(encoder_R.getRate());
			
			rightFront.set(right);
			rightMiddle.set(right);
			rightBack.set(right);
			
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
	
	public static void setAllPowers(double power){
		setLeftPowers(power);
		setRightPowers(-power);
	}
}

