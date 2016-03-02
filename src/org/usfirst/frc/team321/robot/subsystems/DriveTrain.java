package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveWithJoystick;
import org.usfirst.frc.team321.utilities.LancerPID;
import org.usfirst.frc.team321.utilities.MotorValueOutOfBoundsException;

import com.kauailabs.nav6.frc.IMU;
import com.kauailabs.navx_mxp.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
	public final double TICKS_PER_ROTATION = 1420/56;
	public SpeedController leftFront, leftBack, leftMiddle, rightFront, rightMiddle, rightBack;
	public LancerPID PID_R,PID_L;
	public Encoder encoder_L,encoder_R; 
	
	SerialPort navXSerial;
	byte update_rate_hz = 50;
	public IMU navX;
	
	public double AngleValue;

	
	public DriveTrain(){
    	super("Drive Train");
    	
    	leftFront = new Talon(RobotMap.LEFT_FRONT_MOTOR);
    	leftMiddle = new Talon(RobotMap.LEFT_MIDDLE_MOTOR);
    	leftBack = new Talon(RobotMap.LEFT_BACK_MOTOR);
    	rightFront = new Talon(RobotMap.RIGHT_FRONT_MOTOR);
    	rightMiddle = new Talon(RobotMap.RIGHT_MIDDLE_MOTOR);
    	rightBack = new Talon(RobotMap.RIGHT_BACK_MOTOR);
    	
    	//PID_R = new LancerPID(.001,.001,.0005,TICKS_PER_ROTATION/36);
    	//PID_L = new LancerPID(.001,.001,.0005,TICKS_PER_ROTATION/36);
    	
    	encoder_L = new Encoder(RobotMap.ENC_L_A,RobotMap.ENC_L_B);
    	encoder_R = new Encoder(RobotMap.ENC_R_A,RobotMap.ENC_R_B);
    	
    	try{
			navXSerial = new SerialPort(57600, SerialPort.Port.kMXP);
			navX = new AHRS(navXSerial, update_rate_hz);

		} catch( Exception e) {
			//swallow the exception
		}
    }

    public void initDefaultCommand() {
        setDefaultCommand(new MoveWithJoystick());
    }

	public void setLeftPowers(double power){
		if(Math.abs(power) <= 1){
			
			//PID_L.setReference(power);
			//double left = PID_L.calcPID(encoder_L.getRate());
			
			leftFront.set(power * 0.8);
			leftMiddle.set(power * 0.8);
			leftBack.set(power * 0.8);
			
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
	
	public void setRightPowers(double power){
		if(Math.abs(power) <= 1){
			
			//PID_R.setReference(power);
			//double right = PID_R.calcPID(encoder_R.getRate());
			
			rightFront.set(power * 0.8); 
			rightMiddle.set(power * 0.8);
			rightBack.set(power * 0.8);
			
		}else{
			throw new MotorValueOutOfBoundsException();
		}
	}
	
	public void setAllPowers(double power){
		setLeftPowers(power);
		setRightPowers(-power);
	}
}

