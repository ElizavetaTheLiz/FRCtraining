/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;



public class Robot extends TimedRobot{

    private Command autonomousCommand;
    private RobotContainer robotContainer;
    public static DriveSubsystem DriveSubsystem = null;
    public static MotorSubsystem MotorSubsystem = null;
    public static SolenoidSubsystem SolenoidSubsystem = null;



    @Override
    public void robotInit()
    {
        robotContainer = new RobotContainer();
        DriveSubsystem = frc.robot.subsystems.DriveSubsystem.getInstance();
        MotorSubsystem = frc.robot.subsystems.MotorSubsystem.getInstance();
        SolenoidSubsystem = frc.robot.subsystems.SolenoidSubsystem.getInstance();
    }


    @Override
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
    public void teleopPeriodic(){
        DriveSubsystem.Drive(1,3);
        //TODO: BURASI KESINLIKLE YANLIŞ, SAYILARI NASIL DÜZELTECEĞINI ÖĞREN
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
