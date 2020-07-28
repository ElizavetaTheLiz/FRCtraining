package frc.robot.commands.reset;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;


public class ResetElevatorCommand extends CommandBase
{

    private final ElevatorSubsystem elevatorSubsystem = ElevatorSubsystem.getInstance();


    public ResetElevatorCommand() {
        addRequirements(this.elevatorSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        elevatorSubsystem.resetElevEncoder();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
