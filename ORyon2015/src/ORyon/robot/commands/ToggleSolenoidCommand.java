package ORyon.robot.commands;

import ORyon.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleSolenoidCommand extends Command {
	private boolean m_state=false;
	private DoubleSolenoid s;

    private ToggleSolenoidCommand() {
    }
    
    public ToggleSolenoidCommand(DoubleSolenoid sol){
    	s=sol;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        m_state = !m_state;
        Robot.clamp.set(m_state);
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
