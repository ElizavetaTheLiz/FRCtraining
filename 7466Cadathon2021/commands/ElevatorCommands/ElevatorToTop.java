
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ElevatorCommands;

import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ElevatorToTop extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final ElevatorSubsystem elevator = ElevatorSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ElevatorToFloor.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ElevatorToTop(ElevatorSubsystem elevator) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  
  @Override
  public void execute() {
      if(elevator.getElevatorRaising() < Constants.robotFeatures.maxPosElev - Constants.robotFeatures.minPosElev) {
          elevator.elevatorUp(Constants.iO.elevatorSpeed);
      }
      if(elevator.getElevatorRaising() > Constants.robotFeatures.maxPosElev - Constants.robotFeatures.minPosElev) {
          elevator.elevatorDown(-Constants.iO.elevatorSpeed);
      }
      if(elevator.getElevatorRaising() == Constants.robotFeatures.maxPosElev - Constants.robotFeatures.minPosElev) {
          position = true;
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.elevatorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }
}
