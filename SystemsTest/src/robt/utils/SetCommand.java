/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robt.utils;

import edu.wpi.first.wpilibj.SpeedController;
import robt.commands.CommandBase;

/**
 *
 * @author Sam
 * 
 * Can decrement if increment is negative
 */
public class SetCommand extends CommandBase {
    private double setpoint_ = 0.0;
    private SpeedController motor_;
    
    private SetCommand() {
    }
    
    public SetCommand(SpeedController cont){
        this(cont, 0.1);
    }
    
    public SetCommand(SpeedController cont, double setpoint){
        motor_ = cont;
        setpoint_ = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        motor_.set(setpoint_);
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
