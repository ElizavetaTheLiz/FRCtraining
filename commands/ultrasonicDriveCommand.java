
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.drivetrainSubsystem;
import frc.robot.subsystems.joystickSubsystem;
import frc.robot.subsystems.ultrasonicSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ultrasonicDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    boolean position = false;

    private final drivetrainSubsystem drive  = drivetrainSubsystem.getInstance();
    private final joystickSubsystem joystick = joystickSubsystem.getInstance();
    private final ultrasonicSubsystem sonic  = ultrasonicSubsystem.getInstance();

  /**
   * Creates a new ultrasonicDriveCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ultrasonicDriveCommand(drivetrainSubsystem drive, joystickSubsystem joystick, ultrasonicSubsystem sonic) {

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, joystick, sonic);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sonic.ac_kapat(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if(!sonic.engel_var_mi(Constants.Control.sonicDriveDistance)){
        drive.TankDrive(joystick.getRawAxis(Constants.Control.AxisLeft), joystick.getRawAxis(Constants.Control.AxisRight));
      }
      else{
        position = true;
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sonic.ac_kapat(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }
}










