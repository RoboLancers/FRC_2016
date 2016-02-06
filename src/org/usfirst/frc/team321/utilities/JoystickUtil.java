package org.usfirst.frc.team321.utilities;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.subsystems.DriveTrain;

public class JoystickUtil {

	public final static double tolerance = 0.15;

	public static double getLeftXAxisValue(){
		if(Math.abs(OI.driveStick.getRawAxis(0)) > tolerance){
			return OI.driveStick.getRawAxis(0);
		}else{
			return 0;
		}
	}

	public static double getLeftYAxisValue(){
		if(Math.abs(OI.driveStick.getRawAxis(1)) > tolerance){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}

	public static double getRightXAxisValue(){
		if(Math.abs(OI.driveStick.getRawAxis(4)) > tolerance){
			return OI.driveStick.getRawAxis(4);
		}else{
			return 0;
		}
	}
	
	public static double getRightYAxisValue(){
		if(Math.abs(OI.driveStick.getRawAxis(5)) > tolerance){
			return -OI.driveStick.getRawAxis(5);
		}else{
			return 0;
		}
	}
	
	public static double[] arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
	    double leftMotorSpeed = 0;
	    double rightMotorSpeed = 0;
	
	    if (squaredInputs) {
	        if (rotateValue >= 0.0) {
	            rotateValue = (rotateValue * rotateValue);
	        } else {
	            rotateValue = -(rotateValue * rotateValue);
	        }
	        if (moveValue >= 0.0) {
	            moveValue = (moveValue * moveValue);
	        } else {
	            moveValue = -(moveValue * moveValue);
	        }
	    }
	
	    if (rotateValue > 0.0) {
	        if (moveValue > 0.0) {
	            leftMotorSpeed = rotateValue - moveValue;
	            rightMotorSpeed = Math.max(rotateValue, moveValue);
	        } else {
	            leftMotorSpeed = Math.max(rotateValue, -moveValue);
	            rightMotorSpeed = rotateValue + moveValue;
	        }
	    } else {
	        if (moveValue > 0.0) {
	            leftMotorSpeed = -Math.max(-rotateValue, moveValue);
	            rightMotorSpeed = rotateValue + moveValue;
	        } else {
	            leftMotorSpeed = rotateValue - moveValue;
	            rightMotorSpeed = -Math.max(-rotateValue, -moveValue);
	        }
	    }
	    
	    double[] values = {-leftMotorSpeed, -rightMotorSpeed};
	    
	    return values;
	}
}
