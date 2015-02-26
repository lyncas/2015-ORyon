/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORyon.robot.commands;

import ORyon.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 * @author Sam
 * 
 * Can decrement if increment is negative
 */
public class SetSolenoidCommand extends Command {
    private boolean m_position = false;
    private DoubleSolenoid s;
    
    private SetSolenoidCommand() {
    }
    
    
    public SetSolenoidCommand(DoubleSolenoid sol, boolean state){
    	requires(Robot.clamp);
        s = sol;
        m_position = state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.clamp.set(m_position);
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
