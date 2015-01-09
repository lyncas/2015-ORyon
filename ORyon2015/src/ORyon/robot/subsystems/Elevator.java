package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
    
    private Victor lift1; // elevator motor
    private DigitalInput bottom; // button to stop arm when fully down

    public Elevator(){
    	super("Elevator");
    	
    	lift1 = new Victor(HW.lift1); 
    	bottom = new DigitalInput(HW.bot);
    }
    
    
    public void set(double power){
    	SmartDashboard.putBoolean("button", bottom.get());
    	if(bottom.get() || power >= 0){
    		lift1.set(power);
    	}
    	else{
    		lift1.set(0);
    	}
    }

    public void initDefaultCommand() {}

}

