package frc.robot.commands.intake_hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeCommand extends CommandBase
{

    private final IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();


    public IntakeCommand() {
        addRequirements(this.intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intakeSubsystem.intakePos(true);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.intakePos(false);
    }
}
