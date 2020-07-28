package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;


public class ShooterBackCommand extends CommandBase
{

    private final ShooterSubsystem shooterSubsystem = ShooterSubsystem.getInstance();


    public ShooterBackCommand() {
        addRequirements(this.shooterSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shooterSubsystem.shooterBack(true);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.shooterBack(false);
    }
}
