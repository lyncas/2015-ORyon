package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends PIDSubsystem {
    
    private Victor lift1, lift2;
    private Encoder enc; // YUMO model E6A2-CW3C from sparkfun
    
    private final double pulley_circumference = 11.5;//inches
    private final double enc_counts_per_rev = 200 * 4; //x4 for k4X
    private static double 	kP = 0.01,
    						kI = 0.01,
    						kD = 0.01;
    
    public Elevator(){
    	super("Elevator", kP, kI, kD);
    	
    	lift1 = new Victor(HW.lift1);
    	lift2 = new Victor(HW.lift2); 
    	enc = new Encoder(HW.encA,HW.encB,false,EncodingType.k4X);//4X, because why not
    	enc.reset();
    	setPercentTolerance(5.0);
    	this.disable();
    }
    
    
    public void set(double power){
    	lift1.set(power);
    	lift2.set(power);
    }

    public void initDefaultCommand() {
    }


	@Override
	protected double returnPIDInput() {
		double enc_dist_per_count = pulley_circumference / enc_counts_per_rev;
		double input = enc.getRaw() * enc_dist_per_count;
		SmartDashboard.putNumber("height", input);
		return input;
	}


	@Override
	protected void usePIDOutput(double output) {
		lift1.pidWrite(output);
		lift2.pidWrite(output);
		
	}
}

