// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.HangCommands;

import frc.robot.Constants;
import frc.robot.subsystems.HangSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class HangDownCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final HangSubsystem hang = HangSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ElevatorToFloor.
   *
   * @param subsystem The subsystem used by this command.
   */
  public HangDownCommand(HangSubsystem hang) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hang);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  
  @Override
  public void execute() {
      if(hang.encoderGetDegrees() < 0) {
          hang.motorOpenClose(Constants.iO.hangSpeed);
      }
      if(hang.encoderGetDegrees() > 0) {
        hang.motorOpenClose(-Constants.iO.hangSpeed);
      }
      if(hang.encoderGetDegrees() == 0) {
          position = true;
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      hang.motorStop();
      hang.encoderReset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }
}
