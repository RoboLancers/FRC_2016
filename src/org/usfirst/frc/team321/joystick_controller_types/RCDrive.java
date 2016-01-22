package org.usfirst.frc.team321.joystick_controller_types;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.JoystickUtil;

public class RCDrive implements JoystickControllerType {

	@Override
	public void drive() {
		
		//JoystickUtil already checks for tolerance
		if(Math.abs(JoystickUtil.getRightXAxisValue()) > 0){
			Robot.driveTrain.setLeftPowers(JoystickUtil.getRightXAxisValue());	
			Robot.driveTrain.setRightPowers(-JoystickUtil.getRightXAxisValue());
		}else if(Math.abs(JoystickUtil.getLeftYAxisValue()) > 0){
			Robot.driveTrain.setAllPowers(JoystickUtil.getLeftYAxisValue());				
		}else{
			Robot.driveTrain.setAllPowers(0);
		}
	}

}
