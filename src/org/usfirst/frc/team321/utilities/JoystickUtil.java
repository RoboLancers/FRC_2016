package org.usfirst.frc.team321.utilities;

import org.usfirst.frc.team321.robot.OI;

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
		if(Math.abs(OI.driveStick.getRawAxis(0)) > tolerance){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}

	public static double getRightXAxisValue(){
		if(Math.abs(OI.driveStick.getRawAxis(0)) > tolerance){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}

	public static double getRightYAxisValue(){
		if(Math.abs(OI.driveStick.getRawAxis(0)) > tolerance){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}
}
