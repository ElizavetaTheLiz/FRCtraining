

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ultrasonicDriveCommand;
import frc.robot.subsystems.drivetrainSubsystem;
import frc.robot.subsystems.joystickSubsystem;
import frc.robot.subsystems.ultrasonicSubsystem;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  private drivetrainSubsystem drive;
  private joystickSubsystem joystick;
  private ultrasonicSubsystem ultrasonic;
  private ultrasonicDriveCommand ultrasonicDriveCommand;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    drive = drivetrainSubsystem.getInstance();
    joystick = joystickSubsystem.getInstance();
    ultrasonic = ultrasonicSubsystem.getInstance();
    ultrasonicDriveCommand = new ultrasonicDriveCommand(drive, joystick, ultrasonic);


  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();


    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().schedule(ultrasonicDriveCommand);
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}
