
package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.robot.subsystems.Intake;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;
import org.usfirst.frc.team321.utilities.JoystickUtil;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static Pneumatics pneumatics;
	public static Intake intake;
	
	public static OI oi;

    Command autonomousCommand;

    public void robotInit() {
		
		driveTrain = DriveTrain.getInstance();
		intake = Intake.getInstance();
		pneumatics = new Pneumatics();
		
		oi = new OI();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		String robotGear = (Robot.pneumatics.getGear() == DoubleSolenoid.Value.kForward) 
        		? "High Gear" : "Low Gear"; 
        SmartDashboard.putString("Robot Gear", robotGear);
        SmartDashboard.putNumber("Left Y Axis", JoystickUtil.getLeftYAxisValue());
        SmartDashboard.putNumber("Right Y Axis", JoystickUtil.getRightYAxisValue());
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
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
        
        String robotGear = (Robot.pneumatics.getGear() == DoubleSolenoid.Value.kForward) 
        		? "High Gear" : "Low Gear"; 
        SmartDashboard.putString("Robot Gear", robotGear);
        SmartDashboard.putNumber("Left Y Axis", JoystickUtil.getLeftYAxisValue());
        SmartDashboard.putNumber("Right Y Axis", JoystickUtil.getRightYAxisValue());
        SmartDashboard.putString("Right pneumatic gear", Pneumatics.rightDoubleSolenoid.get().toString());
        SmartDashboard.putString("Left pneumatic gear", Pneumatics.leftDoubleSolenoid.get().toString());
     
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
