// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import frc.robot.commands.CommandGroups.HangCommandGroup;
import frc.robot.commands.ElevatorCommands.ElevatorToFloor;
import frc.robot.commands.ElevatorCommands.ElevatorToPortal;
import frc.robot.commands.ElevatorCommands.ElevatorToScale;
import frc.robot.commands.ElevatorCommands.ElevatorToSwitch;
import frc.robot.commands.ElevatorCommands.ElevatorToTop;
import frc.robot.commands.HangCommands.HangDownCommand;
import frc.robot.commands.HangCommands.HangUpCommand;
import frc.robot.commands.IntakeCommands.IntakeInCommand;
import frc.robot.commands.IntakeCommands.IntakeOutCommand;
import frc.robot.commands.IntakeCommands.IntakeTo0Command;
import frc.robot.commands.IntakeCommands.IntakeTo180Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final DriveSubsystem driveSubsystem         = DriveSubsystem.getInstance();
  public final ElevatorSubsystem elevatorSubsystem   = ElevatorSubsystem.getInstance();
  public final HangSubsystem hangSubsystem           = HangSubsystem.getInstance();
  public final IntakeSubsystem intakeSubsystem       = IntakeSubsystem.getInstance();

  public final ElevatorToFloor elevatorToFloor       = new ElevatorToFloor(elevatorSubsystem);
  public final ElevatorToPortal elevatorToPortal     = new ElevatorToPortal(elevatorSubsystem);
  public final ElevatorToScale elevatorToScale       = new ElevatorToScale(elevatorSubsystem);
  public final ElevatorToSwitch elevatorToSwitch     = new ElevatorToSwitch(elevatorSubsystem);
  public final ElevatorToTop elevatorToTop           = new ElevatorToTop(elevatorSubsystem);
  public final HangDownCommand hangDownCommand       = new HangDownCommand(hangSubsystem);
  public final HangUpCommand hangUpCommand           = new HangUpCommand(hangSubsystem);
  public final IntakeInCommand intakeInCommand       = new IntakeInCommand(intakeSubsystem);
  public final IntakeOutCommand intakeOutCommand     = new IntakeOutCommand(intakeSubsystem);
  public final IntakeTo0Command intakeTo0Command     = new IntakeTo0Command(intakeSubsystem);
  public final IntakeTo180Command intakeTo180Command = new IntakeTo180Command(intakeSubsystem);
  public final HangCommandGroup hangCommandGroup     = new HangCommandGroup(hangSubsystem, elevatorSubsystem);
  
  private RamseteController ramseteController        = new RamseteController();



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  /**
  button 0(X)---------------whenActive ElevatorToSwitch
  button 1(A)---------------whenActive ElevatorToFloor
  button 2(B)---------------whenActive ElevatorToPortal
  button 3(Y)---------------whenActive ElevatorToScale
  button 4(left bumper)-----whenActive HangCommandGroup
  button 5(right bumper)----whenActive ElevatorToTop
  button 6(left trigger)----whenActive HangDownCommand
  button 8(back)------------whenActive IntakeTo180Command
  button 9(start)-----------whenActive IntakeTo0Command
  button 10(left joystick)--whileActiveContinuous IntakeInCommand
  button 11(right joystick)-whileActiveContinuous IntakeOutCommand
  -https://modernroboticsinc.com/fusion_docs/img/usbGamepad/gamepad_logitech.png-
  **/

  private void configureButtonBindings() {
    driveSubsystem.getJoystickButtonX().whenActive(elevatorToSwitch);
    driveSubsystem.getJoystickButtonA().whenActive(elevatorToFloor);
    driveSubsystem.getJoystickButtonB().whenActive(elevatorToPortal);
    driveSubsystem.getJoystickButtonY().whenActive(elevatorToScale);
    driveSubsystem.getJoystickButtonLeft().whenActive(hangCommandGroup);
    driveSubsystem.getJoystickButtonRight().whenActive(elevatorToTop);
    driveSubsystem.getJoystickButtonTopLeft().whenActive(hangDownCommand);
    driveSubsystem.getJoystickButtonBack().whenActive(intakeTo180Command);
    driveSubsystem.getJoystickButtonStart().whenActive(intakeTo0Command);
    driveSubsystem.getJoystickButtonBigLeft().whileActiveContinuous(intakeInCommand);
    driveSubsystem.getJoystickButtonBigRight().whileActiveContinuous(intakeOutCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(Trajectory trajectory) {
    // An ExampleCommand will run in autonomous

    
    TrajectoryConfig config = new TrajectoryConfig(
      Constants.autonomous.maxVelocityMetersPerSecond, 
      Constants.autonomous.maxAccelarationMetersPerSecond);
      config.setKinematics(DriveSubsystem.getInstance().getKinematics());

    RamseteCommand ramseteCommand = new RamseteCommand(
      trajectory,
      driveSubsystem::getPose2d, 
      ramseteController, 
      driveSubsystem.getMotorFeedforward(), 
      driveSubsystem.getKinematics(), 
      driveSubsystem::getWheelSpeeds, 
      driveSubsystem.getLeftPID(), 
      driveSubsystem.getRighPID(), 
      driveSubsystem::setMotors, 
      driveSubsystem);

      return ramseteCommand.andThen(() -> driveSubsystem.drive(0, 0));
  }
}
