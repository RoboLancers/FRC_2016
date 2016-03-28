package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;



public class ManualDrive extends Command{
	
	private double distance;
	private double setAngle; 
	private boolean onFirstPass = true;
	
	private double P_ROTATION = (1.0/15), P_DISTANCE = (1.0/10);
	
	
	public ManualDrive(double distance, double setAngle){
		requires(Robot.driveTrain);
		
		this.distance = distance;
		this.setAngle = setAngle;
	}
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	
	protected void onFirstPass(){
		Robot.driveTrain.AngleValue=Robot.driveTrain.navX.getYaw();
		((AHRS)Robot.driveTrain.navX).resetDisplacement();
		onFirstPass = false;
	}
	
	@Override
	protected void execute() {
		
		if(onFirstPass){
			
			onFirstPass();
			
		}else{
			
			if(Math.abs(distance)==0){
				
				double angleError =Robot.driveTrain.navX.getYaw()-setAngle;
				
				while(Math.abs(angleError)<7.5){
					
					Robot.driveTrain.setLeftPowers(P_ROTATION * angleError);
					Robot.driveTrain.setRightPowers(P_ROTATION * angleError);
				}
				
			}else{
				
				double distanceError=((AHRS)Robot.driveTrain.navX).getDisplacementX()-distance;
				
				while(distanceError<10){
					
					Robot.driveTrain.setLeftPowers(P_DISTANCE*distanceError);
					Robot.driveTrain.setRightPowers(P_DISTANCE*distanceError);
				}
			}
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
