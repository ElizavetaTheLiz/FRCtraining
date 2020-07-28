package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;



public class AutoCommand extends CommandBase{
    private final DriveTrainSubsystem driveSubsystem;

    private boolean durum = false;


    public AutoCommand() {
        driveSubsystem = DriveTrainSubsystem.getInstance();
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if (!driveSubsystem.atSetpoint()){
            driveSubsystem.drive(0,0);
            durum = true;
        }
        else{
            driveSubsystem.setSetpoint(Constants.m_setpoint);
        }
    }

    @Override
    public boolean isFinished() {
        return durum;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.drive(0,0);
    }
}