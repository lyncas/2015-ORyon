package ORyon.robot.subsystems;

import ORyon.robot.HW;
import ORyon.robot.commands.elevator.ContinuousLiftCommand;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
    private Victor lift1, lift2;
    
    public Elevator(){
    	super("Elevator");
    	
    	lift1 = new Victor(HW.lift1);
    	lift2 = new Victor(HW.lift2); 
    }
    
    
    public void set(double power){
    	lift1.set(power);
    	lift2.set(power);
    }

    public void initDefaultCommand() {
    }
}

