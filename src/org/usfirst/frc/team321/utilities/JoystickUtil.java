package org.usfirst.frc.team321.utilities;

import org.usfirst.frc.team321.robot.OI;

public class JoystickUtil {

	public final static double tolerance = 0.15;

	public static double getLeftXAxisValue(){
		if(OI.driveStick.getRawAxis(0) > Math.abs(tolerance)){
			return OI.driveStick.getRawAxis(0);
		}else{
			return 0;
		}
	}

	public static double getLeftYAxisValue(){
		if(OI.driveStick.getRawAxis(0) > Math.abs(tolerance)){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}

	public static double getRightXAxisValue(){
		if(OI.driveStick.getRawAxis(0) > Math.abs(tolerance)){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}

	public static double getRightYAxisValue(){
		if(OI.driveStick.getRawAxis(0) > Math.abs(tolerance)){
			return OI.driveStick.getRawAxis(1);
		}else{
			return 0;
		}
	}
}
