package frc.robot.commands.intake.intake_180_degree;

import frc.robot.Constants;
import frc.robot.subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class intakeTo45Command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final intakeSubsystem intake = intakeSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ElevatorToFloor.
   *
   * @param subsystem The subsystem used by this command.
   */
  public intakeTo45Command(intakeSubsystem intake) {
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
      if(intake.getEncoderDegree() < 45) {
          intake.intakeTurn(Constants.iO.intakeSpeed);
      }
      if(intake.getEncoderDegree() > 45) {
        intake.intakeTurnBack(-Constants.iO.intakeSpeed);
      }
      if(intake.getEncoderDegree() == 45) {
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