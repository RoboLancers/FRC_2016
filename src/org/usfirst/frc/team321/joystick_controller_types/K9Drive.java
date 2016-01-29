package org.usfirst.frc.team321.joystick_controller_types;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.JoystickUtil;

public class K9Drive implements JoystickControllerType {
	
	double leftPower,
		   rightPower,
		   power,
		   direction;
	
	@Override
	public void drive() {
		power = JoystickUtil.getLeftYAxisValue();
		direction = JoystickUtil.getLeftXAxisValue();
		rightPower = power - direction; 
		leftPower = power + direction;
		
		Robot.driveTrain.setLeftPowers(leftPower);
		Robot.driveTrain.setRightPowers(rightPower);
	}
}
