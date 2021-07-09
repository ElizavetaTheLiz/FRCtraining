package frc.robot.commands.intake.intake_180_degree;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.intakeSubsystem;

/** An example command that uses an example subsystem. */
public class intakeTo0Command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final intakeSubsystem intake = intakeSubsystem.getInstance();

  private boolean position = false;

  public intakeTo0Command(intakeSubsystem intake) {
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
      if(intake.getEncoderDegree() < 0) {
          intake.intakeTurn(Constants.iO.intakeSpeed);
      }
      if(intake.getEncoderDegree() > 0) {
        intake.intakeTurnBack(-Constants.iO.intakeSpeed);
      }
      if(intake.getEncoderDegree() == 0) {
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