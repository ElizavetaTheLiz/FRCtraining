package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeOutCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();
    private final Timer timer = new Timer();

    public IntakeOutCommand()
    {
        addRequirements(this.intakeSubsystem);
    }
    private boolean durum = false;

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        timer.start();
        if(timer.get() < 2) {
            intakeSubsystem.Intake_Leave_the_Object();
        }
        else {
            durum = true;
        }
    }

    @Override
    public boolean isFinished() {
        return durum;
    }

    @Override
    public void end(boolean interrupted) {
    timer.reset();
    }
}
