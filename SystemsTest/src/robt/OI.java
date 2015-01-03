
package robt;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import robt.commands.CommandBase;
import robt.utils.GamePad;
import robt.utils.GamePad.AxisButton;
import robt.utils.ToggleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    GamePad gp1=new GamePad(1,GamePad.MODE_D);
    
    public Joystick getJoy1() {
        return gp1;
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
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
        //b_B.whenPressed(new ToggleCompressor());
        
        b_X.whenPressed(new ToggleCommand(CommandBase.motors.getMotor(0)));
    }
}

