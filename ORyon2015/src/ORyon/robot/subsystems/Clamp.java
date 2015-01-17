package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clamp extends Subsystem {
    
    private Solenoid s;
    private final boolean close_val = true; // value to close arm

    
    public Clamp(){
    	super("clamp");
    	s=new Solenoid(HW.solenoid);
    }
    
    public void initDefaultCommand() {
    }
    
    public void close(){
    	s.set(close_val);
    }
    
    
    public void open(){
    	s.set(!close_val);
    }
    
    public void set(boolean close){
    	s.set(close != close_val);
    }
    
    public Solenoid getSolenoid(){
    	return s;
    }
    
    
}

