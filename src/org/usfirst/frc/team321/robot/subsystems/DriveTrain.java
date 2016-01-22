package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.MoveWithJoystick;
import org.usfirst.frc.team321.utilities.JoystickUtil;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
	private static DriveTrain driveTrain;
	private static SpeedController frontLeft, frontRight, rearLeft, rearRight;
	
	private DriveTrain(){
    	super("Drive Train");
    	
    	frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR);
    	frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR);
    	rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR);
    	rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR);
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

	public SpeedController getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeftPower(double power) {
		if(Math.abs(power) <= 1){
			DriveTrain.frontLeft.set(power);;
		}else{
			throw new RuntimeException("frontLeft power is greater than 1 or less than -1");
		}
	}

	public SpeedController getFrontRight() {
		return frontRight;
	}

	public void setFrontRightPower(double power) {
		if(Math.abs(power) <= 1){
			DriveTrain.frontRight.set(power);;
		}else{
			throw new RuntimeException("frontRight power is greater than 1 or less than -1");
		}
	}

	public SpeedController getRearLeft() {
		return rearLeft;
	}

	public void setRearLeftPower(double power) {
		if(Math.abs(power) <= 1){
			DriveTrain.rearLeft.set(power);;
		}else{
			throw new RuntimeException("rearLeft power is greater than 1 or less than -1");
		}
	}

	public SpeedController getRearRight() {
		return rearRight;
	}

	public void setRearRightPower(double power) {
		if(Math.abs(power) <= 1){
			DriveTrain.rearLeft.set(power);;
		}else{
			throw new RuntimeException("rearRight power is greater than 1 or less than -1");
		}
	}
    
	public void setLeftPowers(double power){
		setFrontLeftPower(power);
		setRearLeftPower(power);
	}
	
	public void setRightPowers(double power){
		setFrontRightPower(power);
		setRearRightPower(power);
	}
	
	public void setAllPowers(double power){
		setLeftPowers(power);
		setRightPowers(power);
	}
    
}

