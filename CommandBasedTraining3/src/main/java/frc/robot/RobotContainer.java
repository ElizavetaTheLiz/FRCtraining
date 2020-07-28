/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.commands.intake_hopper.HopperCommand;
import frc.robot.commands.intake_hopper.IntakeCommand;
import frc.robot.commands.reset.ResetDriveCommand;
import frc.robot.commands.reset.ResetElevatorCommand;
import frc.robot.commands.shooter.ShooterBackCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.subsystems.ShooterSubsystem;


public class RobotContainer
{
    public static Joystick Stick1 = new Joystick(Constants.JoystickPort1);
    public static Joystick Stick2 = new Joystick(Constants.JoystickPort2);

    public static JoystickButton elevDown_button = new JoystickButton(Stick2, Constants.elevDown_button);
    public static JoystickButton elevUp_button   = new JoystickButton(Stick2, Constants.elevUp_button);

    JoystickButton int_hop_button    = new JoystickButton(Stick2,Constants.int_hop_button);
    JoystickButton shooter_button    = new JoystickButton(Stick2,Constants.shooter_button);
    JoystickButton elevReset_button  = new JoystickButton(Stick2,Constants.elevReset_button);
    JoystickButton driveReset_button = new JoystickButton(Stick2,Constants.driveReset_button);


    private final ShooterSubsystem shooterSubsystem         = ShooterSubsystem.getInstance();
    private final AutoCommand autoCommand                   = new AutoCommand();
    private final HopperCommand hopperCommand               = new HopperCommand();
    private final IntakeCommand intakeCommand               = new IntakeCommand();
    private final ResetDriveCommand resetDriveCommand       = new ResetDriveCommand();
    private final ResetElevatorCommand resetElevatorCommand = new ResetElevatorCommand();
    private final ShooterBackCommand shooterBackCommand     = new ShooterBackCommand();
    private final ShooterCommand shooterCommand             = new ShooterCommand(0.7, shooterSubsystem);

    private final ParallelCommandGroup commandGroup = new ParallelCommandGroup(intakeCommand, hopperCommand, shooterBackCommand);

    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();
    }


    private void configureButtonBindings()
    {
        int_hop_button   .whileActiveContinuous(commandGroup);
        shooter_button   .whileActiveContinuous(shooterCommand);
        elevReset_button .whenActive(resetElevatorCommand);
        driveReset_button.whenActive(resetDriveCommand);
    }


    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return autoCommand;
    }
}
