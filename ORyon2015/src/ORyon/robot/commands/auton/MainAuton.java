package ORyon.robot.commands.auton;

import ORyon.robot.Robot;
import ORyon.robot.commands.CommandLogger;
import ORyon.robot.commands.SetSolenoidCommand;
import ORyon.robot.commands.drivetrain.MoveTimeCommand;
import ORyon.robot.commands.elevator.ContinuousLiftCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
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

        // A  command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	/*
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),true));
    	addSequential(new WaitCommand(2));
    	addSequential(new ContinuousLiftCommand(1));
    	addSequential(new WaitCommand(3));
    	addSequential(new ContinuousLiftCommand(0.5));
    	addSequential(new MoveTimeCommand(2,-0.5,0.4));
    	addSequential(new ContinuousLiftCommand(0));
    	addSequential(new MoveTimeCommand(2,0.7,0));
    	*/
    	//Time to do things (easier to change this than all instances of it)
    	double tRot90 = .3;
    	double tSolenoid = 1;
    	
    	//Grab trash can, rotate with it, place it down
    	addSequential(new CommandLogger("a "));
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),true));
    	addSequential(new WaitCommand(tSolenoid));
    	TimedLift(-1, .5, "a1 ");
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),false));
    	addSequential(new WaitCommand(tSolenoid));
    	TimedLift(1, .5, "a2 ");
    	addSequential(new CommandLogger("b"));
    	addSequential(new MoveTimeCommand(tRot90, 0, 1));
    	addSequential(new CommandLogger("c"));
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),true));
    	addSequential(new CommandLogger("d"));
    	addSequential(new WaitCommand(tSolenoid));
    	addSequential(new CommandLogger("e"));
    	//Lift arm over can, rotate back, lower onto tote
    	//Timed Lift is because I am lazy and it conserves space :)
    	TimedLift(1, .5, "f");
    	addSequential(new MoveTimeCommand(tRot90, 0, -1));
    	TimedLift(-1, 1, "g");
/*
    	//Grab tote, rotate 180 degree (not 2x power), raise arm
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid().false));
    	addSequential(new WaitCommand(tSolenoid));
    	addSequential(new MoveTimeCommand(1.4*tRot90, 0, -1));
    	addSequential(new ContinuousLiftCommand(1));
    	addSequential(new WaitCommand(.5));
    	addSequential(new ContinuousLiftCommand(0));
    	
    	//Drive to 2nd tote, lower arm onto it, pick it up
    	addSequential(new MoveTimeCommand(.5, .5, 0));
    	//Drop
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),true));
    	addSequential(new WaitCommand(tSolenoid));
    	addSequential(new ContinuousLiftCommand(-1));
    	addSequential(new WaitCommand(.5));
    	addSequential(new ContinuousLiftCommand(0));    	
    	//Grab
    	addSequential(new SetSolenoidCommand(Robot.clamp.getSolenoid(),false));
    	addSequential(new WaitCommand(tSolenoid));
    	addSequential(new ContinuousLiftCommand(1));
    	addSequential(new WaitCommand(.5));
    	addSequential(new ContinuousLiftCommand(0));
  */  	
    	
    }
    
    public void TimedLift(double power, double time, String l) {
    	addSequential(new CommandLogger(l + "a"));
    	addSequential(new ContinuousLiftCommand(power));
    	addSequential(new CommandLogger(l + "b"));
    	addSequential(new WaitCommand(time));
    	addSequential(new CommandLogger(l + "c"));
    	addSequential(new ContinuousLiftCommand(0));
    	addSequential(new CommandLogger(l + "d"));
    }
}
