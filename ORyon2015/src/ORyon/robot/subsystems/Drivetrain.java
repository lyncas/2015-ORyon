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
    private Victor backLeft2;
    private Victor backRight2;
    private BetterDrive drive;
    
    public Drivetrain(){
    	super("Drivetrain");
    	
    	frontLeftDrive = new Victor(HW.frontleft);
    	backLeftDrive = new Victor(HW.backleft);
    	frontRightDrive = new Victor(HW.frontright);
    	backRightDrive = new Victor(HW.backrght);
    	
    	drive = new BetterDrive(frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive);
    	drive.setSafetyEnabled(false);
    }

    public void initDefaultCommand() {
    	// Our speed is way to high, so limit to approximately 60%
        setDefaultCommand(new LerpDrive(0.6));
    }
    
    public void tankDriveUnsmoothed(double left, double right){
    	drive.tankDrive(left, right,false,false);
        backLeft2.set(drive.getLeftPower());
        backRight2.set(drive.getRightPower());
    }

    public void arcadeDrive(double move, double turn) {
    	drive.arcadeDrive(move, turn, true);
    	backLeft2.set(drive.getLeftPower());
    	backRight2.set(drive.getRightPower());
    }
}

