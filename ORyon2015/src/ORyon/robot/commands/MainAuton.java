package ORyon.robot.commands;

import ORyon.robot.Robot;
import ORyon.robot.commands.drivetrain.MoveTimeCommand;
import ORyon.robot.commands.elevator.ContinuousLiftCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * A sequence of commands to create a simple time-based autonomous
 */
public class MainAuton extends CommandGroup {
    
    public  MainAuton() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),true));
    	addSequential(new WaitCommand(2));
    	addSequential(new ContinuousLiftCommand(1));
    	addSequential(new WaitCommand(3));
    	addSequential(new ContinuousLiftCommand(0.5));
    	addSequential(new MoveTimeCommand(2,-0.5,0.4));
    	addSequential(new ContinuousLiftCommand(0));
    	addSequential(new MoveTimeCommand(2,0.7,0));
    }
}
