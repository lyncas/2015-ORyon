package ORyon.robot;
/**
 * HW (Hardware) is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
	
	// DRIVE MOTORS
    public static final int 
    		frontleft = 0, frontright = 1,
    		backleft = 2, backrght = 3;
    
    // ELEVATOR MOTORS
    public static final int
    		lift1 = 6;
    
    // ELEVATOR BUTTONS
    public static final int 
    		bot = 9;
    
    // CLAMP SOLENOIDS
    public static final int
    		solenoid = 0;
}
