package ORyon.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import ORyon.robot.commands.elevator.ContinuousLiftCommand;
import ORyon.robot.utils.GamePad;
import ORyon.robot.utils.GamePad.AxisButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	GamePad gp1=new GamePad(1,GamePad.MODE_D);
	
	public Joystick getJoy1() {
        return gp1;
    }
    
    private Button b_dpadU = new AxisButton(gp1, GamePad.DPAD_Y_U);
    private Button b_dpadD = new AxisButton(gp1, GamePad.DPAD_Y_D);
    private Button b_dpadR = new AxisButton(gp1, GamePad.DPAD_X_R);
    private Button b_dpadL = new AxisButton(gp1, GamePad.DPAD_X_L);
    private Button b_bumpR = new JoystickButton(gp1, gp1.BUMPER_R);
    private Button b_bumpL = new JoystickButton(gp1, gp1.BUMPER_L);
    private Button b_trigR = new JoystickButton(gp1, gp1.TRIGGER_R);
    private Button b_trigL = new JoystickButton(gp1, gp1.TRIGGER_L);
    private Button b_Back = new JoystickButton(gp1, gp1.BTN_BACK);
    private Button b_Start = new JoystickButton(gp1, gp1.BTN_START);
    private Button b_A = new JoystickButton(gp1, gp1.BTN_A);
    private Button b_X = new JoystickButton(gp1, gp1.BTN_X);
    private Button b_B = new JoystickButton(gp1, gp1.BTN_B);
    private Button b_Y = new JoystickButton(gp1, gp1.BTN_Y);
    private Button b_clicR = new JoystickButton(gp1, gp1.CLICK_R);
    private Button b_clicL = new JoystickButton(gp1, gp1.CLICK_L);
    
    
    public OI(){
    	b_trigR.whileHeld(new ContinuousLiftCommand(1));
    	b_trigL.whileHeld(new ContinuousLiftCommand(-1));
    }
}

