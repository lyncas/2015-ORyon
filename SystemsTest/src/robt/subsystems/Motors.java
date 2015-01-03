/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robt.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import robt.HW;

/**
 *
 * @author Sam
 */
public class Motors extends Subsystem {
    Talon[] motors = new Talon[6];
    
    public Motors() {
        super("motors");
        for(int i = HW.MOTORS_BEGIN; i < HW.MOTORS_BEGIN+6; i++){
            motors[i] = new Talon(1,i);
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getPWM(int channel){
        return motors[channel].get();
    }
    
    public void setPWM(int channel, double power){
        motors[channel].set(power);
    }
    
    public SpeedController getMotor(int channel){
        return motors[channel];
    }
}
