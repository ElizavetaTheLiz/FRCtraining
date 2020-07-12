/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorSubsystem;



public class MotorCommand extends CommandBase{

    public MotorSubsystem m_motor = MotorSubsystem.getInstance();

    public MotorCommand()
    {
        addRequirements(this.m_motor);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_motor.motorcalistirma(1.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_motor.motorcalistirma(0);

    }

}
