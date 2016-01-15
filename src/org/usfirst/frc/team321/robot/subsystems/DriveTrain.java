package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveWithJoystick;
import org.usfirst.frc.team321.utilities.JoystickUtil;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
	private static DriveTrain driveTrain;
	private RobotDrive robotDrive;
	
	private DriveTrain(){
    	super("Drive Train");
    	
    	robotDrive = new RobotDrive(RobotMap.FRONT_LEFT_MOTOR, RobotMap.REAR_RIGHT_MOTOR,
    			RobotMap.FRONT_RIGHT_MOTOR, RobotMap.REAR_RIGHT_MOTOR);
    	
    }
	
	public static DriveTrain getInstance(){
		
		if(driveTrain == null){
			driveTrain = new DriveTrain();
		}
		return driveTrain;
	}

    public void initDefaultCommand() {
        setDefaultCommand(new MoveWithJoystick());
    }
    
    public RobotDrive getRobotDrive(){
    	return robotDrive;
    }
    
    public void drive(){
    	robotDrive.tankDrive(JoystickUtil.getLeftYAxisValue(), JoystickUtil.getRightYAxisValue());
    }
}

