package robt;

/**
 * HW is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
   
    //MOTORS
    public static final int 
            left1slot=1,    left1channel=1,
            left2slot=1,    left2channel=2,
            right1slot=1,   right1channel=3,
            right2slot=1,   right2channel=4;
    
    //RELAYS
    public static final int 
            compressorSlot=1,   compressorChannel=6;
    
    //SENSORS
    public static final int 
            presssureSwitchSlot=1,  pressureSwitchChannel=1;
}
