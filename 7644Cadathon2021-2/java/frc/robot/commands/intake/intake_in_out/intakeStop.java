
package frc.robot.commands.intake.intake_in_out;

import frc.robot.subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakeStop extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final intakeSubsystem intake = intakeSubsystem.getInstance();


  public intakeStop(intakeSubsystem intakeSubsystem) {
    addRequirements(intakeSubsystem);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    intake.stop_intake_motors();
  }


  @Override
  public void end(boolean interrupted) {
    intake.stop_intake_motors();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
