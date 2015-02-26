package ORyon.robot.commands.elevator;

import ORyon.robot.Robot;
import ORyon.robot.commands.ToggleSolenoidCommand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStackCommand extends Command {

	private int count;
	private int mode;
	private boolean finished;
	public static final int MODE_ADD = 0;
	public static final int MODE_DROP = 1;
	
    public AutoStackCommand() {
    	requires(Robot.elevator);
    	requires(Robot.clamp);
    	count = 0;
    	mode = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = !Robot.elevator.getPositionButton();
    	count = 0;
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	boolean liftAtBottom, liftAtTop, toteIn, toteGrabbed, hasChangedTotes;
    	liftAtBottom = Robot.elevator.getBotSwitch();
    	liftAtTop = Robot.elevator.getTopSwitch();
    	toteIn= Robot.elevator.getPositionButton();
    	toteGrabbed = Robot.clamp.getGrabButton();
    	hasChangedTotes = false;
    	
    	if(!hasChangedTotes) {
    		Robot.clamp.set(true);
    		hasChangedTotes = true;
    	}
    	
    	if(!liftAtBottom && !toteGrabbed) {
    		Robot.elevator.set(-0.5);
    	} else {
    		Robot.elevator.set(0);
    	}
    	
    	if(liftAtBottom && !toteGrabbed) {
    		Robot.clamp.set(false);
    		finished = false;
    	}
    	
    	if(liftAtBottom && toteGrabbed && count<50) {
    		Robot.elevator.set(0.5);
    		count++;
    	} else {
    		Robot.elevator.set(0);
    	}
    	
    	

    	//Pseudocode
    	/*
    	 * Lower elevator until at release height (default)
    	 * Release tote in storage (if any)
    	 * Lower to bottom
    	 * Grab stack of totes
    	 * Raise to release height again
    	 */
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.elevator.getPositionButton();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.set(0);
    	new ContinuousLiftCommand(.5).start();
    	//
    	//THIS NEEDS TO TIME OUT WHEN AT OPTIMAL HEIGHT
    	//
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
