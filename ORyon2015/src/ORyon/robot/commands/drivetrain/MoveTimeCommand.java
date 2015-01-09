package ORyon.robot.commands.drivetrain;

import ORyon.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTimeCommand extends Command {
	
	private double m_move, m_turn;

    public MoveTimeCommand(double seconds, double move, double turn) {
    	super(seconds); // set timeout
        requires(Robot.drivetrain);
        m_move=move;
        m_turn=turn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.arcadeDrive(m_move, m_turn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
