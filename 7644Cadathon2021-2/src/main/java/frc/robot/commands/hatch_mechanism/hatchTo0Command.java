// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.hatch_mechanism;


import frc.robot.subsystems.hatchSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class hatchTo0Command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  
  private final hatchSubsystem hatch = hatchSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public hatchTo0Command(hatchSubsystem hatch) {
    addRequirements(hatch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(hatch.getHatchDegrees() < 0){
        hatch.open_hatch_motor(0.7);
    }

    if(hatch.getHatchDegrees() > 0){
       hatch.open_hatch_motor(-0.7);
    }

    if(hatch.getHatchDegrees() == 0) {
      position = true;
  }
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hatch.stop_hatch_motor();
  }
  public boolean isFinished() {
    return position;
  }
}
