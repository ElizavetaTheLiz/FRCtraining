package frc.robot.commands.elevatorAndHang;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class ElevatorSwitchCommand extends CommandBase {
    private final ElevatorSubsystem elevator = ElevatorSubsystem.getInstance();

    private boolean position = false;

    public ElevatorSwitchCommand() {
        addRequirements(this.elevator);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if(elevator.getElevatorRaising() < Constants.RobotFeatures.switchPosIntake - Constants.RobotFeatures.minPosIntake) {
            elevator.elevatorUp();
        }
        if(elevator.getElevatorRaising() > Constants.RobotFeatures.switchPosIntake - Constants.RobotFeatures.minPosIntake) {
            elevator.elevatorDown();
        }
        if(elevator.getElevatorRaising() == Constants.RobotFeatures.switchPosIntake - Constants.RobotFeatures.minPosIntake) {
            position = true;
        }
    }

    @Override
    public boolean isFinished() {
        return position;
    }

    @Override
    public void end(boolean interrupted) {
        elevator.elevatorStop();
    }
}