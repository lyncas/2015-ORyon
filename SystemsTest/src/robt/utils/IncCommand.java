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
public class IncCommand extends CommandBase {
    private double inc_ = 0.0;
    private SpeedController motor_;
    
    private IncCommand() {
    }
    
    public IncCommand(SpeedController cont){
        this(cont, 0.1);
    }
    
    public IncCommand(SpeedController cont, double increment){
        motor_ = cont;
        inc_ = increment;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        motor_.set(motor_.get() + inc_);
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
