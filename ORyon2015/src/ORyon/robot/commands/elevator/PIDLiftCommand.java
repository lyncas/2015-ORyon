package ORyon.robot.commands.elevator;

import ORyon.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDLiftCommand extends Command {
	private double m_setpoint;

	// Setpoint is inches above min
    public PIDLiftCommand(double setpoint) {
        requires(Robot.elevator);
        m_setpoint=setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
