

package frc.robot;

import frc.robot.commands.autoCommand;
import frc.robot.commands.redlineCommand;
import frc.robot.subsystems.drivetrainSubsystem;
import frc.robot.subsystems.encoderSubsystem;
import frc.robot.subsystems.joystickSubsystem;
import frc.robot.subsystems.redlineSubsystem;
import frc.robot.subsystems.ultrasonicSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {
  private drivetrainSubsystem drive      = drivetrainSubsystem.getInstance();
  private encoderSubsystem encoder       = encoderSubsystem.getInstance();
  private redlineSubsystem redline       = redlineSubsystem.getInstance();
  private ultrasonicSubsystem ultrasonic = ultrasonicSubsystem.getInstance();
  private joystickSubsystem joystick     = joystickSubsystem.getInstance();
  private autoCommand auto               = new autoCommand(drive, encoder, ultrasonic);
  private redlineCommand redlineCommand  = new redlineCommand(redline);



  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    joystick.button.whileActiveContinuous(redlineCommand);
  }


  public Command getAutonomousCommand() {
    return auto;
  }
}
