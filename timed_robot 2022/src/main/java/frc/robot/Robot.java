// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();


  private PWMVictorSPX leftVictorSPX = new PWMVictorSPX(0);
  private PWMVictorSPX left2VictorSPX = new PWMVictorSPX(1);
  private PWMVictorSPX left3VictorSPX = new PWMVictorSPX(2);
  private PWMVictorSPX rightVictorSPX = new PWMVictorSPX(3);
  private PWMVictorSPX right2VictorSPX = new PWMVictorSPX(4);
  private PWMVictorSPX right3VictorSPX = new PWMVictorSPX(5);

  private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftVictorSPX, left2VictorSPX, left3VictorSPX);
  private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightVictorSPX, right2VictorSPX, right3VictorSPX);
  private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  private PWMVictorSPX elevLeftMotor = new PWMVictorSPX(6);
  private PWMVictorSPX elevRightMotor = new PWMVictorSPX(7);
  private SpeedControllerGroup elevatorMotors = new SpeedControllerGroup(elevLeftMotor, elevRightMotor);

  private PWMVictorSPX intakeRightMotor = new PWMVictorSPX(8);
  private PWMVictorSPX intakeLeftMotor = new PWMVictorSPX(9);
  private SpeedControllerGroup intakeMotors = new SpeedControllerGroup(intakeLeftMotor, intakeRightMotor);
  
  private final double elevatorMin = 10.0;
  private final double elevatorLevel1 = 15.0;
  private final double elevatorLevel2 = 40.0;
  private final double elevatorLevel3 = 60.0;

  private final Encoder encoder = new Encoder(0, 1, false);

  private Joystick joystick = new Joystick(0);

  private JoystickButton buttonX = new JoystickButton(joystick, 0);
  private JoystickButton buttonA = new JoystickButton(joystick, 1);
  private JoystickButton buttonB = new JoystickButton(joystick, 2);
  private JoystickButton buttonY = new JoystickButton(joystick, 3);
  private final int joystickAxis1 = 0;
  private final int joystickAxis2 = 2;

  private final Timer timer = new Timer();

  private boolean buttonA_position = false;
  private boolean buttonX_position = false;
  private boolean buttonY_position = false;
  private boolean intake_position = false;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    encoder.setDistancePerPulse(5.0/24);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    timer.reset();
    timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        break;
      case kDefaultAuto:
      
    if(encoder.getDistance()< elevatorLevel1-elevatorMin){
      elevLeftMotor.set(0.7);
    }
    else if(encoder.getDistance() == elevatorLevel1-elevatorMin){
      elevLeftMotor.set(0);
    }
    else if(encoder.getDistance()> elevatorLevel1-elevatorMin){
      elevLeftMotor.set(-0.7);
    }


      default:
      if(timer.get()<5){
        drive.tankDrive(0.5, 0.5);
      }
      else if(timer.get()>= 5 && timer.get()< 15){
        drive.tankDrive(0.3, 0.3);
      }
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    drive.tankDrive(joystick.getRawAxis(joystickAxis1), joystick.getRawAxis(joystickAxis2));

    if(buttonA.get()){
      buttonA_position = true;
    }

    if(buttonA_position){
      if(encoder.getDistance()< elevatorLevel1-elevatorMin){
        elevLeftMotor.set(0.7);
      }
      else if(encoder.getDistance() == elevatorLevel1-elevatorMin){
        elevLeftMotor.set(0);
        buttonA_position = false;
      }
      else if(encoder.getDistance()> elevatorLevel1-elevatorMin){
        elevLeftMotor.set(-0.7);
      }
    }

    if(buttonX.get()){
      buttonX_position = true;
    }

    if(buttonX_position){
      if(encoder.getDistance()< elevatorLevel2-elevatorMin){
        elevLeftMotor.set(0.7);
      }
      else if(encoder.getDistance() == elevatorLevel2-elevatorMin){
        elevLeftMotor.set(0);
        buttonX_position = false;
      }
      else if(encoder.getDistance()> elevatorLevel2-elevatorMin){
        elevLeftMotor.set(-0.7);
      }
    }

    if(buttonY.get()){
      buttonY_position = true;
    }

    if(buttonY_position){
      if(encoder.getDistance()< elevatorLevel3-elevatorMin){
        elevLeftMotor.set(0.7);
      }
      else if(encoder.getDistance() == elevatorLevel3-elevatorMin){
        elevLeftMotor.set(0);
        buttonY_position = false;
      }
      else if(encoder.getDistance()> elevatorLevel3-elevatorMin){
        elevLeftMotor.set(-0.7);
      }
    }

    if(buttonB.get()){
      if(intake_position){
        intake_position = false;
      }
      else if(intake_position == false){
        intake_position = true;
      }
    }


    if(intake_position){
      intakeMotors.set(0.7);
    }
    else{
      intakeMotors.set(0);
    }


  }


  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    drive.tankDrive(0, 0);
    elevatorMotors.disable();
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
