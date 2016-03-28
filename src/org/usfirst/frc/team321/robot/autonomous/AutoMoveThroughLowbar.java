package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.utilities.LancerPID;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoMoveThroughLowbar extends Command {

	//Numbers are in meters
	//56:1
	//public final double DISTANCE = 3.0;
	//public final double DIAMETER = 0.254;

	private LancerPID autoPID_L;
	private LancerPID autoPID_R;

	private long time;

	private boolean hasFinished;
	private boolean operatingPivot;
	private boolean firstPassDrive;
	private boolean isDriving;


	Encoder encoder_R;
	Encoder encoder_L;
	Encoder encoder_P;

	public AutoMoveThroughLowbar(Encoder encoder_L, Encoder encoder_R /* ,Encoder encoder_P */) {
		requires(Robot.driveTrain);
		this.encoder_R = encoder_R;
		this.encoder_L = encoder_L;
		//this.encoder_P = encoder_P;

		hasFinished=false;
		operatingPivot = true;
		firstPassDrive = false;
		isDriving = false;

		autoPID_L = new LancerPID(1,1,0);
		autoPID_R = new LancerPID(1,1,0);

		//double rotationsRequired = DISTANCE/DIAMETER;
		//double encoderTicksRequired = rotationsRequired * Robot.driveTrain.TICKS_PER_ROTATION;

	}

	protected void initialize() {

	}

	protected void execute() {
		
		if(Robot.intakePivot.pivotMotor.getEncPosition() < 9000 && operatingPivot)//change number
			Robot.intakePivot.setPivotMotor(-.8);
		else if(operatingPivot){
			Robot.intakePivot.setPivotMotor(0);
			Robot.intakePivot.lockPivotMotor();
			operatingPivot = false;
			firstPassDrive = isDriving = true;
		}

		if(isDriving){
			if(firstPassDrive){
				time = System.currentTimeMillis();	
				firstPassDrive = false;
			}else{


				autoPID_L.setReference(.5);
				autoPID_R.setReference(.5);

				if(System.currentTimeMillis() - time < 4000){
					Robot.driveTrain.setLeftPowers(autoPID_L.calcPID(Robot.driveTrain.encoder_L.getRate()));
					Robot.driveTrain.setRightPowers(autoPID_R.calcPID(Robot.driveTrain.encoder_R.getRate()));

				}else{hasFinished = true;}
			}
		}
	}

	protected boolean isFinished() {
		return hasFinished;
	}

	protected void end() {
		Robot.driveTrain.setAllPowers(0);
	}

	protected void interrupted() {
		Robot.driveTrain.setAllPowers(0);
		Robot.intakePivot.setPivotMotor(0);
		Robot.intakePivot.lockPivotMotor();
		
	}
}
