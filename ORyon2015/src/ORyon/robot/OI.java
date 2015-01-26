package ORyon.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import ORyon.robot.commands.ToggleSolenoidCommand;
import ORyon.robot.commands.elevator.ContinuousLiftCommand;
import ORyon.robot.utils.GamePad;
import ORyon.robot.utils.GamePad.AxisButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	GamePad gp1=new GamePad(1,GamePad.MODE_D);
	GamePad gp2=new GamePad(2,GamePad.MODE_D);
	
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
    
    
    private Button b2_dpadU = new AxisButton(gp2, GamePad.DPAD_Y_U);
    private Button b2_dpadD = new AxisButton(gp2, GamePad.DPAD_Y_D);
    private Button b2_dpadR = new AxisButton(gp2, GamePad.DPAD_X_R);
    private Button b2_dpadL = new AxisButton(gp2, GamePad.DPAD_X_L);
    private Button b2_bumpR = new JoystickButton(gp2, gp2.BUMPER_R);
    private Button b2_bumpL = new JoystickButton(gp2, gp2.BUMPER_L);
    private Button b2_trigR = new JoystickButton(gp2, gp2.TRIGGER_R);
    private Button b2_trigL = new JoystickButton(gp2, gp2.TRIGGER_L);
    private Button b2_Back = new JoystickButton(gp2, gp2.BTN_BACK);
    private Button b2_Start = new JoystickButton(gp2, gp2.BTN_START);
    private Button b2_A = new JoystickButton(gp2, gp2.BTN_A);
    private Button b2_X = new JoystickButton(gp2, gp2.BTN_X);
    private Button b2_B = new JoystickButton(gp2, gp2.BTN_B);
    private Button b2_Y = new JoystickButton(gp2, gp2.BTN_Y);
    private Button b2_clicR = new JoystickButton(gp2, gp2.CLICK_R);
    private Button b2_clicL = new JoystickButton(gp2, gp2.CLICK_L);
    
    public OI(){
    	b_trigR.whenPressed(new ContinuousLiftCommand(1));
    	b_trigR.whenReleased(new ContinuousLiftCommand(0));

    	b_trigL.whenPressed(new ContinuousLiftCommand(-1));
    	b_trigL.whenReleased(new ContinuousLiftCommand(0));
    	
    	b_bumpR.whenPressed(new ContinuousLiftCommand(0.3));
    	b_bumpR.whenReleased(new ContinuousLiftCommand(0));

    	b_bumpL.whenPressed(new ContinuousLiftCommand(-0.1));
    	b_bumpL.whenReleased(new ContinuousLiftCommand(0));

    	b_X.whenPressed(new ToggleSolenoidCommand(Robot.clamp.getSolenoid()));
    	
    	
    	/*b2_trigR.whileHeld(new ContinuousLiftCommand(1));
    	b2_trigL.whileHeld(new ContinuousLiftCommand(-1));
    	 
    	b2_bumpR.whileHeld(new ContinuousLiftCommand(0.3));
    	b2_bumpL.whileHeld(new ContinuousLiftCommand(-0.3));
    	
    	b2_X.whenPressed(new ToggleSolenoidCommand(Robot.clamp.getSolenoid()));*/
    }
}

