package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.autonomous.AutonomousMoveThroughDefense;
import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.robot.subsystems.Intake;
import org.usfirst.frc.team321.robot.subsystems.IntakePivot;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;
import org.usfirst.frc.team321.utilities.JoystickUtil;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static Intake intake;
	public static DriveTrain driveTrain;
	public static Pneumatics pneumatics;
	public static IntakePivot intakePivot;
	
	public static OI oi;

    Command autonomousCommand;

    public void robotInit() {
		
    	intake = new Intake();
    	driveTrain = new DriveTrain();
    	pneumatics = new Pneumatics();
    	intakePivot = new IntakePivot();
    	
		oi = new OI();
    }
	
    private void setupSmartDashboard(){
        SmartDashboard.putNumber("Left Y Axis", JoystickUtil.getLeftYAxisValue());
        SmartDashboard.putNumber("Right Y Axis", JoystickUtil.getRightYAxisValue());
        
        String robotGear = (pneumatics.getGear() == DoubleSolenoid.Value.kForward) 
        		? "High Gear" : "Low Gear"; 
        SmartDashboard.putString("Robot Gear", robotGear);
        SmartDashboard.putString("Left pneumatic gear", 
        		pneumatics.leftDoubleSolenoid.get().toString());
        SmartDashboard.putString("Right pneumatic gear", 
        		pneumatics.rightDoubleSolenoid.get().toString());
        
        SmartDashboard.putBoolean("Direction of encoder left", driveTrain.encoder_L.getDirection());
        SmartDashboard.putBoolean("Direction of encoder right", driveTrain.encoder_R.getDirection());
        SmartDashboard.putNumber("Encoder left speed", driveTrain.encoder_L.getRate()/8000);
        SmartDashboard.putNumber("Encoder right speed", driveTrain.encoder_R.getRate()/8000);
        
        SmartDashboard.putBoolean("Pneumatics pressure: ", Robot.pneumatics.getPressure());
        SmartDashboard.putBoolean("Pneumatics switch value : ", Robot.pneumatics.compressor.getPressureSwitchValue());
        SmartDashboard.putBoolean("Pneumatics state (is enabled?):", Robot.pneumatics.compressor.enabled());
        SmartDashboard.putBoolean("Pnematics get closed loop control :", Robot.pneumatics.compressor.getClosedLoopControl());
        SmartDashboard.putNumber("Pneumatics current ", Robot.pneumatics.compressor.getCompressorCurrent());
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
        setupSmartDashboard();
	}

    public void autonomousInit() {
    	//Doesn't matter which encoder you use
    	autonomousCommand = new AutonomousMoveThroughDefense(Robot.driveTrain.encoder_L);
        if (autonomousCommand != null) {
        	autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        setupSmartDashboard();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
