package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clamp extends Subsystem {
    
    private DoubleSolenoid s;
    private final boolean close_val = true; // value to close arm
    private DigitalInput grabTote;
    
    public Clamp(){
    	super("clamp");
    	s=new DoubleSolenoid(HW.solenoid, HW.solenoidB);
		grabTote = new DigitalInput(HW.grab);
    }
    
    public void initDefaultCommand() {
    }
    
    /*public void close(){
    	s.set(close_val);
    }*/
    
    public boolean getGrabButton() {
    	return !grabTote.get();
    }
    
    
    /*public void open(){
    	s.set(!close_val);
    }*/
    
    public void set(boolean close){
    	if(close_val)
    		s.set(DoubleSolenoid.Value.kForward);
    	else
    		s.set(DoubleSolenoid.Value.kReverse);
    }
    
    public DoubleSolenoid getSolenoid(){
    	return s;
    }
    
    
}

