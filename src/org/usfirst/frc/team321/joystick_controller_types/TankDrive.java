package org.usfirst.frc.team321.joystick_controller_types;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.JoystickUtil;

public class TankDrive implements JoystickControllerType {

	@Override
	public void drive() {
		Robot.driveTrain.setLeftPowers(JoystickUtil.getLeftYAxisValue());
		
		Robot.driveTrain.setRightPowers(JoystickUtil.getRightYAxisValue());
	}

}
