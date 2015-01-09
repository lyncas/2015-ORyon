package ORyon.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleSolenoidCommand extends Command {
	private boolean m_state=false;
	private Solenoid s;
    
    public ToggleSolenoidCommand(Solenoid sol){
    	s=sol;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        m_state = !m_state;
        s.set(m_state);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
