
package frc.robot;

import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import frc.robot.commands.climber.climberDown;
import frc.robot.commands.climber.climberTo2Step;
import frc.robot.commands.climber.climberTo3Step;
import frc.robot.commands.drivetrain.driveCommand;
import frc.robot.commands.hatch_mechanism.hatchTo0Command;
import frc.robot.commands.hatch_mechanism.hatchTo90Command;
import frc.robot.commands.intake.intake_180_degree.intakeTo0Command;
import frc.robot.commands.intake.intake_180_degree.intakeTo135Command;
import frc.robot.commands.intake.intake_180_degree.intakeTo180Command;
import frc.robot.commands.intake.intake_180_degree.intakeTo45Command;
import frc.robot.commands.intake.intake_in_out.intakeIn;
import frc.robot.commands.intake.intake_in_out.intakeOut;
import frc.robot.commands.intake.intake_in_out.intakeStop;
import frc.robot.subsystems.climberSubsystem;
import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.hatchSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import frc.robot.subsystems.joystickSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;


public class RobotContainer {
  private final climberSubsystem cSubsystem = climberSubsystem.getInstance();
  private final hatchSubsystem hSubsystem = hatchSubsystem.getInstance();
  private final driveSubsystem dSubsystem = driveSubsystem.getInstance();
  private final intakeSubsystem iSubsystem = intakeSubsystem.getInstance();
  private final joystickSubsystem jSubsystem = joystickSubsystem.getInstance();

  private final climberDown clDownCommand = new climberDown(cSubsystem);
  private final climberTo2Step cTo2StepCommand = new climberTo2Step(cSubsystem);
  private final climberTo3Step cTo3StepCommand = new climberTo3Step(cSubsystem);
  private final driveCommand dCommand = new driveCommand(dSubsystem, jSubsystem);
  private final hatchTo0Command hTo0Command = new hatchTo0Command(hSubsystem);
  private final hatchTo90Command hTo90Command = new hatchTo90Command(hSubsystem);
  private final intakeTo0Command iTo0Command = new intakeTo0Command(iSubsystem);
  private final intakeTo45Command iTo45Command = new intakeTo45Command(iSubsystem);
  private final intakeTo135Command iTo135Command = new intakeTo135Command(iSubsystem);
  private final intakeTo180Command iTo180Command = new intakeTo180Command(iSubsystem);
  private final intakeIn iInCommand = new intakeIn(iSubsystem);
  private final intakeOut iOutCommand = new intakeOut(iSubsystem);
  private final intakeStop iStopCommand = new intakeStop(iSubsystem);

  private RamseteController ramseteController = new RamseteController();

  public RobotContainer() {
    configureButtonBindings();
  }

  /**
  button 0(X)---------------whenActive/whileActiveContinuous - command name 
  button 1(A)---------------whenActive/whileActiveContinuous - command name 
  button 2(B)---------------whenActive/whileActiveContinuous - command name 
  button 3(Y)---------------whenActive/whileActiveContinuous - command name 
  button 4(left bumper)-----whenActive/whileActiveContinuous - command name 
  button 5(right bumper)----whenActive/whileActiveContinuous - command name 
  button 6(left trigger)----whenActive/whileActiveContinuous - command name 
  button 8(back)------------whenActive/whileActiveContinuous - command name 
  button 9(start)-----------whenActive/whileActiveContinuous - command name 
  button 10(left joystick)--whenActive/whileActiveContinuous - command name 
  button 11(right joystick)-whenActive/whileActiveContinuous - command name 
  -https://modernroboticsinc.com/fusion_docs/img/usbGamepad/gamepad_logitech.png-
  */

  private void configureButtonBindings() {
    jSubsystem.getJoystickButtonX().whenActive(dCommand);

  }
  
  public Command getAutonomousCommand(Trajectory trajectory) {
    // An ExampleCommand will run in autonomous

    
    TrajectoryConfig config = new TrajectoryConfig(
      Constants.autonomous.maxVelocityMetersPerSecond, 
      Constants.autonomous.maxAccelarationMetersPerSecond);
      config.setKinematics(driveSubsystem.getInstance().getKinematics());

    RamseteCommand ramseteCommand = new RamseteCommand(
      trajectory,
      dSubsystem::getPose2d, 
      ramseteController, 
      dSubsystem.getMotorFeedforward(), 
      dSubsystem.getKinematics(), 
      dSubsystem::getWheelSpeeds, 
      dSubsystem.getLeftPID(), 
      dSubsystem.getRighPID(), 
      dSubsystem::setMotors, 
      dSubsystem);

      return ramseteCommand.andThen(() -> dSubsystem.tankDrive(0, 0));
  }
}