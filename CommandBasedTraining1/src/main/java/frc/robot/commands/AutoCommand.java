package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveSubsystem;



public class AutoCommand extends CommandBase{
    Timer timer = new Timer();
    private final DriveSubsystem driveSubsystem;


    public AutoCommand() {
        driveSubsystem = DriveSubsystem.getInstance();
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        while (timer.get() < 4){
            driveSubsystem.Drive(1, 1);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.Drive(0, 0);
        timer.stop();
    }
}
