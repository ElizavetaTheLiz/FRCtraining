package frc.robot.commands.elevatorAndHang;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.HangSubsystem;

public class ElevatorHangCommand extends CommandBase {
    private final ElevatorSubsystem elevator = ElevatorSubsystem.getInstance();
    private final HangSubsystem hang = HangSubsystem.getInstance();
    private final Timer timer = new Timer();

    private boolean position = false;

    public ElevatorHangCommand() {
        addRequirements(this.elevator);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        hang.hangOpen();
        if(elevator.getElevatorRaising() < Constants.RobotFeatures.hangPosElev) {
            elevator.elevatorUp();
        }
        if(elevator.getElevatorRaising() > Constants.RobotFeatures.hangPosElev) {
            elevator.elevatorDown();
        }
        if(elevator.getElevatorRaising() == Constants.RobotFeatures.hangPosElev && timer.get() >= 2.5) {
            position = true;
        }
    }

    @Override
    public boolean isFinished() {
        return position;
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        elevator.elevatorStop();
        hang.hangStop();
    }
}