package frc.robot.commands.intake;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeInCommand extends CommandBase {
    public IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();

    public IntakeInCommand() {
        addRequirements(this.intakeSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intakeSubsystem.Intake_Take_the_Object();
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}