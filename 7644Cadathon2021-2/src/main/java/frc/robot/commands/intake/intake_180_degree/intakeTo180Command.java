// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake.intake_180_degree;


import frc.robot.subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class intakeTo180Command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  
  private final intakeSubsystem intake = intakeSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public intakeTo180Command(intakeSubsystem intake) {
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(intake.getEncoderDegree() < 180){
       intake.intakeTurn(0.7);
    }

    if(intake.getEncoderDegree() > 180){
       intake.intakeTurnBack(-0.7);
    }

    if(intake.getEncoderDegree() == 180) {
      position = true;
  }
}
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop180Turning();
}
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }
}

