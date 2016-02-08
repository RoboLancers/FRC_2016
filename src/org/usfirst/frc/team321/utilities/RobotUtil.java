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
}
