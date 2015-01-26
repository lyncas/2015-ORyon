package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clamp extends Subsystem {
    
    private Solenoid s;
    private final boolean close_val = true; // value to close arm
    private DigitalInput grabTote;
    
    public Clamp(){
    	super("clamp");
    	s=new Solenoid(HW.solenoid);
		grabTote = new DigitalInput(HW.grab);
    }
    
    public void initDefaultCommand() {
    }
    
    public void close(){
    	s.set(close_val);
    }
    
    public boolean getGrabButton() {
    	return !grabTote.get();
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

