package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeTo0Command extends CommandBase {
    private final IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();

    private boolean position = false;

    public IntakeTo0Command(){
        addRequirements(this.intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(intakeSubsystem.getAngle() < 0){
            intakeSubsystem.TurnOn();
        }
        if(intakeSubsystem.getAngle() > 0){
            intakeSubsystem.TurnBack();
        }
        if(intakeSubsystem.getAngle() == 0){
            position = true;
        }
    }

    @Override
    public boolean isFinished() {
        return position;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.IntakeStop();
    }
}
