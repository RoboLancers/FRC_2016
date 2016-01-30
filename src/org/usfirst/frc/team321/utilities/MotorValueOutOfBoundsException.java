package org.usfirst.frc.team321.utilities;

public class MotorValueOutOfBoundsException extends RuntimeException {

	private static final long serialVersionUID = -1930531801224621957L;

	public MotorValueOutOfBoundsException(){
		super("Power was set greater than 1 or less than -1");
	}
}
