package org.usfirst.frc.team321.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	public static DoubleSolenoid leftDoubleSolenoid;
    public static DoubleSolenoid rightDoubleSolenoid;

	public Pneumatics() {
		leftDoubleSolenoid = new DoubleSolenoid(0, 1);
		rightDoubleSolenoid = new DoubleSolenoid(2, 3);
	}
	
    public void initDefaultCommand() {
    }    
}

