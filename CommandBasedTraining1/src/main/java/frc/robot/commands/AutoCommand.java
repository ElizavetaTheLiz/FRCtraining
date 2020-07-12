package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;



public class AutoCommand extends CommandBase{
    Timer timer = new Timer();
    private final DriveSubsystem driveSubsystem;

    private boolean durum = false;


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
        if (timer.get() < 4){
            driveSubsystem.Drive(Constants.Joystick.Axis1, Constants.Joystick.Axis2);
        }
        else{
            durum = true;
        }
    }

    @Override
    public boolean isFinished() {
        return durum;
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
    }
}
