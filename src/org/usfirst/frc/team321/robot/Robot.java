package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.autonomous.AutoMoveThroughLowbar;
import org.usfirst.frc.team321.robot.autonomous.AutonomousMoveThroughDefense;
import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.robot.subsystems.Intake;
import org.usfirst.frc.team321.robot.subsystems.IntakePivot;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static Intake intake;
	public static DriveTrain driveTrain;
	public static Pneumatics pneumatics;
	public static IntakePivot intakePivot;
	
	public static OI oi;
	
	public SendableChooser autoChooser;
    Command autonomousCommand;

    public void robotInit() {
		
    	intake = new Intake();
    	driveTrain = new DriveTrain();
    	pneumatics = new Pneumatics();
    	intakePivot = new IntakePivot();
    	
		oi = new OI();
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("No Autonomous", null);
		autoChooser.addObject("Drive Forward", new AutonomousMoveThroughDefense());
		autoChooser.addObject("Drive Through Lowbar", new AutoMoveThroughLowbar(driveTrain.encoder_L, driveTrain.encoder_R));
		
		//ahrs = new AHRS(SerialPort.Port.kMXP);
		SmartDashboard.putData("Auto Mode", autoChooser);
    }
	
    private void setupSmartDashboard(){
        SmartDashboard.putNumber("Left Displacement", driveTrain.encoder_L.getDistance());
        SmartDashboard.putNumber("Right Displacement", driveTrain.encoder_R.getDistance());
        SmartDashboard.putNumber("Encoder left speed", driveTrain.encoder_L.getRate()/8000);
        SmartDashboard.putNumber("Encoder right speed", driveTrain.encoder_R.getRate()/8000);

        SmartDashboard.putNumber("Roll", driveTrain.navX.getRoll());
        SmartDashboard.putNumber("Pitch", driveTrain.navX.getPitch());
        SmartDashboard.putNumber("Yaw", driveTrain.navX.getYaw());

        SmartDashboard.putNumber("X", driveTrain.navX.getDisplacementX());
        SmartDashboard.putNumber("Y", driveTrain.navX.getDisplacementY());
        SmartDashboard.putNumber("Z", driveTrain.navX.getDisplacementZ());
        
        SmartDashboard.putBoolean("Gear", pneumatics.gearShiftSolenoid.get()==DoubleSolenoid.Value.kForward ? true : false);
        
        SmartDashboard.putNumber("Intake Pivot", Robot.intakePivot.pivotMotor.getEncPosition());
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
        setupSmartDashboard();
	}

    public void autonomousInit() {
    	//Doesn't matter which encoder you use
    	autonomousCommand = (Command) autoChooser.getSelected();// null;//new AutonomousMoveThroughDefense();//new AutoMoveThroughLowbar(Robot.driveTrain.encoder_L,Robot.driveTrain.encoder_R);
    	
        if (autonomousCommand != null) {
        	autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        setupSmartDashboard();
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