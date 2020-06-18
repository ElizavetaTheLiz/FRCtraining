/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * The VM is configured to automatically run this class, and to call the
 * methods corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */


public class Robot extends TimedRobot
{

    public PWMVictorSPX leftFrontMC  = new PWMVictorSPX(1);
    public PWMVictorSPX leftBackMC   = new PWMVictorSPX(2);
    public PWMVictorSPX rightFrontMC = new PWMVictorSPX(3);
    public PWMVictorSPX rightBackMC  = new PWMVictorSPX(4);

    public SpeedControllerGroup leftMC  = new SpeedControllerGroup  (leftFrontMC, leftBackMC);
    public SpeedControllerGroup rightMC = new SpeedControllerGroup(rightFrontMC, rightBackMC);

    public DifferentialDrive myDrive = new DifferentialDrive(leftMC, rightMC);

    public Timer theTimer = new Timer();

    public Joystick myJoystick = new Joystick(0);

    public JoystickButton button1 = new JoystickButton(myJoystick,1);
    public JoystickButton button2 = new JoystickButton(myJoystick,2);

    public PWMVictorSPX lastMotor  = new PWMVictorSPX(0);

    public Solenoid solenoid1 = new Solenoid(1);


    /**
     * This method is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {

    }

    /**
     * This method is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     * <p>
     * This runs after the mode specific periodic methods, but before
     * LiveWindow and SmartDashboard integrated updating.
     */


    @Override
    public void robotPeriodic()
    {
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString line to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional comparisons to
     * the switch structure below with additional strings. If using the
     * SendableChooser make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit()
    {
        theTimer.reset();
        theTimer.start();
    }

    /**
     * This method is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
        if (theTimer.get() < 4.0){
            myDrive.tankDrive(1,1);
        }
        else{
            myDrive.stopMotor();
        }
    }

    /**
     * This method is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic()
    {
        myDrive.tankDrive(myJoystick.getRawAxis(1), myJoystick.getRawAxis(3));

        if(button1.get()){
            solenoid1.set(true);
        }
        else{
            solenoid1.set(false);
        }


        if(button2.get()){
            lastMotor.set(1);
        }
        else{
            lastMotor.set(0);
        }
    }

    /**
     * This method is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
    }
}
