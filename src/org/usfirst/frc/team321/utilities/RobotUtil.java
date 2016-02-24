package org.usfirst.frc.team321.utilities;

public class RobotUtil {
	
	public static double range(double input, double min, double max){
		
		if(input > max){
			return max;
		}else if(input < min){
			return min;
		}else{
			return input;
		}
	}
	
	public static double squareAndKeepSign(double num){	
		if(num < 0){
			return -(num * num);
		}else{
			return num * num;
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
