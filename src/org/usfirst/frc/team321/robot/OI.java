package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.commands.SwitchGear;
import org.usfirst.frc.team321.robot.commands.UseIntake;
import org.usfirst.frc.team321.robot.subsystems.Intake.IntakeValues;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick driveStick, maniStick;
	public static JoystickButton[] driveBtn, maniBtn;
	
	private final int BUTTON_A = 0;
	
	public OI(){
		
		driveStick = new Joystick(0);
		maniStick = new Joystick(1);
		
		driveBtn = new JoystickButton[12];
		maniBtn = new JoystickButton[12];
		
		for(int i = 0; i < driveBtn.length; i++){
			driveBtn[i] = new JoystickButton(driveStick, i + 1);
		}

		for(int i = 0; i < maniBtn.length; i++){
			maniBtn[i] = new JoystickButton(maniStick, i + 1);
		}
		
		driveBtn[BUTTON_A].whenPressed(new SwitchGear());
		
		maniBtn[0].whileHeld(new UseIntake(IntakeValues.INTAKE));
		maniBtn[1].whileHeld(new UseIntake(IntakeValues.OUTTAKE));
		
		
	}
	
}

