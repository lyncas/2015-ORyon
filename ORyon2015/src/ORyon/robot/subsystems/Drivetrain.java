package ORyon.robot.subsystems;

import ORyon.robot.HW;
import ORyon.robot.commands.drivetrain.LerpDrive;
import ORyon.robot.utils.BetterDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	private Victor frontLeftDrive;
    private Victor backLeftDrive;
    private Victor frontRightDrive;
    private Victor backRightDrive;
    
    private BetterDrive drive;
    
    public Drivetrain(){
    	super("Drivetrain");
    	
    	frontLeftDrive = new Victor(HW.frontleft);
    	backLeftDrive = new Victor(HW.backleft);
    	frontRightDrive = new Victor(HW.frontright);
    	backRightDrive = new Victor(HW.backrght);
    	
    	drive = new BetterDrive(frontLeftDrive, backLeftDrive, frontRightDrive, backLeftDrive);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LerpDrive());
    }
    
    public void tankDriveUnsmoothed(double left, double right){
            drive.tankDrive(left, right,false,false);
    }

    public void arcadeDrive(double move, double turn) {
	drive.arcadeDrive(move, turn, true);
    }
}

