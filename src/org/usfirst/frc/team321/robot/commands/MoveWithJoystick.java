package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.utilities.JoystickUtil;
import org.usfirst.frc.team321.utilities.RobotUtil;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWithJoystick extends Command {
	
	private boolean rcDrive = false;
	private DriveTrain driveTrain;
	
    public MoveWithJoystick() {
        requires(Robot.driveTrain);
        this.driveTrain = Robot.driveTrain;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(rcDrive){
    		double[] motorValues = RobotUtil.arcadeDrive(JoystickUtil.getLeftYAxisValue(),
    				JoystickUtil.getRightXAxisValue(), true);
    		
    		driveTrain.setLeftPowers(motorValues[0]);
    		driveTrain.setRightPowers(motorValues[1]);
    	}else{
    		driveTrain.setLeftPowers(JoystickUtil.getLeftYAxisNormalized());
       		driveTrain.setRightPowers(JoystickUtil.getRightYAxisNormalized());
     	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
