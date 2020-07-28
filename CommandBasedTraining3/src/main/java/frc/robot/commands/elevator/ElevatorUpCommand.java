package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;


public class ElevatorUpCommand extends CommandBase
{

    private final ElevatorSubsystem elevSubsystem = ElevatorSubsystem.getInstance();

    private boolean position = false;

    public ElevatorUpCommand() {
        addRequirements(this.elevSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(elevSubsystem.getEncoderPosition() > Constants.elevatorTopPosition){
            position = true;
        }
        else {
            elevSubsystem.moveElevator(true);
        }
    }

    @Override
    public boolean isFinished() {
        return position;
    }

    @Override
    public void end(boolean interrupted) {
        elevSubsystem.stopElevator();
    }
}
