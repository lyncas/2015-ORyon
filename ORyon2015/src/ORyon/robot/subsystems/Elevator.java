package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends PIDSubsystem {
    
    private Victor lift1, lift2;
    private Encoder enc;
    
    public Elevator(){
    	super("Elevator", 0.01, 0.01, 0.01);
    	
    	lift1 = new Victor(HW.lift1);
    	lift2 = new Victor(HW.lift2); 
    	enc = new Encoder(HW.encA,HW.encB,false,EncodingType.k4X);
    }
    
    
    public void set(double power){
    	lift1.set(power);
    	lift2.set(power);
    }

    public void initDefaultCommand() {
    }


	@Override
	protected double returnPIDInput() {
		return enc.get();
	}


	@Override
	protected void usePIDOutput(double output) {
		lift1.pidWrite(output);
		lift2.pidWrite(output);
		
	}
}

