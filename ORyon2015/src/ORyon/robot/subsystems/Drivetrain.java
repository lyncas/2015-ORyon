package ORyon.robot.subsystems;

import ORyon.robot.HW;
import ORyon.robot.commands.drivetrain.LerpDrive;
import ORyon.robot.utils.BetterDrive;
import ORyon.robot.utils.Lidar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private Lidar lidar;

	public Drivetrain() {
		super("Drivetrain");

		frontLeftDrive = new Victor(HW.frontleft);
		backLeftDrive = new Victor(HW.backleft);
		frontRightDrive = new Victor(HW.frontright);
		backRightDrive = new Victor(HW.backrght);
		backLeft2 = new Victor(HW.backLeft2);
		backRight2 = new Victor(HW.backRight2);

		drive = new BetterDrive(frontLeftDrive, backLeftDrive, frontRightDrive,
				backRightDrive);
		// drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setSafetyEnabled(false);

		lidar = new Lidar(HW.i2cLidarAddress);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new LerpDrive(0.6));
	}

	public void tankDriveUnsmoothed(double left, double right) {
		drive.tankDrive(left, right, false, false);
		backLeft2.set(drive.getLeftPower());
		backRight2.set(drive.getRightPower());
	}

	public void arcadeDrive(double move, double turn) {
		drive.arcadeDrive(move, turn, true);
		backLeft2.set(drive.getLeftPower());
		backRight2.set(drive.getRightPower());
	}

	public void updateLidarSmartDash() {
		SmartDashboard.putNumber("Lidar Inches", lidar.getDistanceIn());
	}

}
