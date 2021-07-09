

package frc.robot.commands.drivetrain;

import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.joystickSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class driveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  public driveSubsystem drive = driveSubsystem.getInstance();
  public joystickSubsystem joystick = joystickSubsystem.getInstance(); 

  public driveCommand(driveSubsystem drive, joystickSubsystem joystick) {
    addRequirements(drive, joystick);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    drive.tankDrive(joystick.getJoystick().getRawAxis(1), joystick.getJoystick().getRawAxis(3));
  }


  @Override
  public void end(boolean interrupted) {
    drive.tankDrive(0, 0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
