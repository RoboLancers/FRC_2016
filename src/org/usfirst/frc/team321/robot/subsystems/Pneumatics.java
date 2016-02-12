package org.usfirst.frc.team321.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	private static Pneumatics pneumatics;
	public DoubleSolenoid leftDoubleSolenoid;
    public DoubleSolenoid rightDoubleSolenoid;
    
	private Pneumatics() {
		leftDoubleSolenoid = new DoubleSolenoid(0, 1);
		rightDoubleSolenoid = new DoubleSolenoid(2, 3);
	}
	
    public void initDefaultCommand() {
    }    
    
    public Value getGear(){
    	//Left solenoid is the one that determines the gear, since the right gear is inverted.
    	return leftDoubleSolenoid.get();
    }
    
    public DoubleSolenoid getLeftDoubleSolenoid() {
		return leftDoubleSolenoid;
	}

	public void setLeftDoubleSolenoid(DoubleSolenoid leftDoubleSolenoid) {
		this.leftDoubleSolenoid = leftDoubleSolenoid;
	}

	public DoubleSolenoid getRightDoubleSolenoid() {
		return rightDoubleSolenoid;
	}

	public void setRightDoubleSolenoid(DoubleSolenoid rightDoubleSolenoid) {
		this.rightDoubleSolenoid = rightDoubleSolenoid;
	}

	public static Pneumatics getInstance(){
		if(null == pneumatics){
			pneumatics = new Pneumatics();
		}
		return pneumatics;
	}
}

