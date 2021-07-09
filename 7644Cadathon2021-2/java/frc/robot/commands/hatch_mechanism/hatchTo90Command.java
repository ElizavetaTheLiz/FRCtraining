package frc.robot.commands.hatch_mechanism;



import frc.robot.subsystems.hatchSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class hatchTo90Command extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  
  private final hatchSubsystem hatch = hatchSubsystem.getInstance();

  private boolean position = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public hatchTo90Command(hatchSubsystem hatch) {
    addRequirements(hatch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(hatch.getHatchDegrees() < 90){
       hatch.open_hatch_motor(0.7);
    }

    if(hatch.getHatchDegrees() > 90){
       hatch.open_hatch_motor(-0.7);
    }

    if(hatch.getHatchDegrees() == 90) { 
        hatch.stop_hatch_motor();
  }
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      hatch.stop_hatch_motor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return position;
  }

}
