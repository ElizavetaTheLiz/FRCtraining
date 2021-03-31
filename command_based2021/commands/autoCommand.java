
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.drivetrainSubsystem;
import frc.robot.subsystems.encoderSubsystem;
import frc.robot.subsystems.ultrasonicSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class autoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})


  boolean position = false;

  private final drivetrainSubsystem drive = drivetrainSubsystem.getInstance();
  private final encoderSubsystem encoder  = encoderSubsystem.getInstance();
  private final ultrasonicSubsystem sonic = ultrasonicSubsystem.getInstance();


  /**
   * Creates a new autoCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public autoCommand(drivetrainSubsystem drive, encoderSubsystem encoder, ultrasonicSubsystem ultrasonic) {

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, encoder, ultrasonic);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      encoder.reset();
      sonic.ac_kapat(true);
      encoder.setDistance();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if((encoder.getDistance() < 200) && (!sonic.engel_var_mi(5))){
        drive.TankDrive(0.7, 0.7);
      }
      else{
          position = true;
      }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      sonic.ac_kapat(false);
      drive.TankDrive(0, 0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }
}
