/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robt.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import robt.HW;
import robt.utils.TalonCompressor;

/**
 *
 * @author Developer
 */
public class CompressorSub extends Subsystem {
    TalonCompressor comp=new TalonCompressor(HW.presssureSwitchSlot,HW.pressureSwitchChannel,HW.compressorSlot,HW.compressorChannel);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void enable(){
        comp.start();
    }
    
    public void disable(){
        comp.stop();
    }
    
    public boolean getEnabled(){
        return comp.enabled();
    }
    
}
