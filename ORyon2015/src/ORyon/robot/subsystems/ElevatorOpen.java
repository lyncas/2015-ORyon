package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorOpen extends Subsystem {

	private Victor lift1, lift2;
	private DigitalInput limitTop, limitBottom, positionTote;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public ElevatorOpen() {
		lift1 = new Victor(HW.lift1);
		lift2 = new Victor(HW.lift2);
		limitTop = new DigitalInput(HW.top);
		limitBottom = new DigitalInput(HW.bot);
    	positionTote = new DigitalInput(HW.position);
	}
	
	public boolean getTopSwitch() {
		return !limitTop.get();
	}
	
	public boolean getBotSwitch() {
		return !limitBottom.get();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void set(double input) {
		double output = input;
		if (getTopSwitch() && output > 0) {
			output = 0;
		} else if (getBotSwitch() && output < 0) {
			output = 0;
		}
		lift1.set(output);
		lift2.set(output);
	}
    public boolean getPositionButton() {
    	return !positionTote.get();
    }
}
