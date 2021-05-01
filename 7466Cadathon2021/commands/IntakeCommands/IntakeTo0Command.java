// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class IntakeTo0Command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final IntakeSubsystem intake = IntakeSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ElevatorToFloor.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeTo0Command(IntakeSubsystem intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  
  @Override
  public void execute() {
      if(intake.encoderGetDegrees() < 0) {
          intake.intakeTurn(Constants.iO.intakeSpeed);
      }
      if(intake.encoderGetDegrees() > 0) {
        intake.intakeTurnBack(-Constants.iO.intakeSpeed);
      }
      if(intake.encoderGetDegrees() == 0) {
          position = true;
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      intake.intakeTurnStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }
}
