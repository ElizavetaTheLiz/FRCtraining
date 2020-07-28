package frc.robot.commands.reset;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;


public class ResetDriveCommand extends CommandBase
{

    private final DriveTrainSubsystem driveSubsystem = DriveTrainSubsystem.getInstance();


    public ResetDriveCommand() {
        addRequirements(this.driveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveSubsystem.resetDriveEncoders();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
