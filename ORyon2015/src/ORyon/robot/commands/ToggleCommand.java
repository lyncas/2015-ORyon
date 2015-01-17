/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORyon.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Sam
 */
public class ToggleCommand extends Command {
    private boolean state_ = false;
    private double power_ = 0.0;
    private SpeedController motor_;
    
    private ToggleCommand() {
    }
    
    public ToggleCommand(SpeedController cont){
        this(cont, 1.0);
    }
    
    public ToggleCommand(SpeedController cont, double power){
        motor_= cont;
        power_ = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        state_ = !state_;
        if(state_){
            motor_.set(power_);
        }
        else{
            motor_.set(0);
        }
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
