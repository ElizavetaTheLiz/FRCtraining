
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.UltrasonicDriveCommand;
import frc.robot.subsystems.*;



public class Robot extends TimedRobot {
    private Command autonomousCommand;

    private RobotContainer robotContainer;
    public static DriveSubsystem DriveSubsystem = null;
    public static EncoderSubsystem EncoderSubsystem = null;
    public static JoystickSubsystem JoystickSubsystem = null;
    public static RedlineSubsystem RedlineSubsystem = null;
    public static UltrasonicSubsystem UltrasonicSubsystem = null;

    public static UltrasonicDriveCommand sonicDrive = new UltrasonicDriveCommand();


    @Override
    public void robotInit()
    {
        robotContainer      = new RobotContainer();
        DriveSubsystem      = frc.robot.subsystems.DriveSubsystem.getInstance();
        EncoderSubsystem    = frc.robot.subsystems.EncoderSubsystem.getInstance();
        JoystickSubsystem   = frc.robot.subsystems.JoystickSubsystem.getInstance();
        RedlineSubsystem    = frc.robot.subsystems.RedlineSubsystem.getInstance();
        UltrasonicSubsystem = frc.robot.subsystems.UltrasonicSubsystem.getInstance();
    }



    public void robotPeriodic()
    {
        CommandScheduler.getInstance().run();
    }


    @Override
    public void disabledInit()
    {
    }

    @Override
    public void disabledPeriodic()
    {
    }


    @Override
    public void autonomousInit()
    {
        autonomousCommand = robotContainer.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        {
            autonomousCommand.schedule();
        }
    }


    @Override
    public void autonomousPeriodic()
    {
    }

    @Override
    public void teleopInit()
    {
        if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }
    }


    @Override
    public void teleopPeriodic() {
        CommandScheduler.getInstance().schedule(sonicDrive);
    }


    @Override
    public void testInit()
    {
        CommandScheduler.getInstance().cancelAll();
    }


    @Override
    public void testPeriodic()
    {
    }
}
