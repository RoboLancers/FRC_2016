
package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.subsystems.DriveTrain;
import org.usfirst.frc.team321.robot.subsystems.Intake;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
