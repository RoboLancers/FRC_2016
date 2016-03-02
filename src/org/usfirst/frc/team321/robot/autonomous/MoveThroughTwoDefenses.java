package org.usfirst.frc.team321.robot.autonomous;

import org.usfirst.frc.team321.robot.commands.RegulateCompressor;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveThroughTwoDefenses extends CommandGroup{
	
	private int delta;
	private final int DISTANCE = 1;
	
	public MoveThroughTwoDefenses(int init, int fin){
			delta = fin-init;
			delta =  delta*DISTANCE;
			
			addParallel(new RegulateCompressor());
			
			addSequential(new ManualDrive(10,0));
			addSequential(new ManualDrive(0,90));
			addSequential(new ManualDrive(delta,0));
			addSequential(new ManualDrive(0,180));
			addSequential(new ManualDrive(10,0));
			addSequential(new ManualDrive(-10,0));
	}

}
