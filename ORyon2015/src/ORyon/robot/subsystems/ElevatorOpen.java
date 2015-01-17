package ORyon.robot.subsystems;

import ORyon.robot.HW;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorOpen extends Subsystem {

	private Victor lift1, lift2;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public ElevatorOpen() {
		lift1 = new Victor(HW.lift1);
		lift2 = new Victor(HW.lift2);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void set(double b) {
		lift1.set(b);
		lift2.set(b);
	}
}
