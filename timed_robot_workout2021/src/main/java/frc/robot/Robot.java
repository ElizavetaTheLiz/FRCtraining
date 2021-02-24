
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto  = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();


  public PWMVictorSPX left1  = new PWMVictorSPX(1);
  public PWMVictorSPX left2  = new PWMVictorSPX(2);
  public PWMVictorSPX right1 = new PWMVictorSPX(3);
  public PWMVictorSPX right2 = new PWMVictorSPX(4);

  public SpeedControllerGroup left_motors  = new SpeedControllerGroup(left1, left2);
  public SpeedControllerGroup right_motors = new SpeedControllerGroup(right1, right2);

  public DifferentialDrive drive = new DifferentialDrive(left_motors, right_motors);

  public Encoder left_encoder = new Encoder(5, 6);
  public Encoder right_encoder = new Encoder(7, 8);

  public double wheelRad = 10;
  public double left_encoder_pulse = 32;
  public double right_encoder_pulse = 32;

  public Joystick joystick = new Joystick(0);

  public JoystickButton buttonX = new JoystickButton(joystick, 0);
  public JoystickButton buttonA = new JoystickButton(joystick, 1);
  public JoystickButton buttonB = new JoystickButton(joystick, 2);
  public JoystickButton buttonY = new JoystickButton(joystick, 3);

  public PWMVictorSPX intake_motor = new PWMVictorSPX(9);

  public PWMVictorSPX shooter_motor1 = new PWMVictorSPX(10);
  public PWMVictorSPX shooter_motor2 = new PWMVictorSPX(11);
  public SpeedControllerGroup shooter_motors = new SpeedControllerGroup(shooter_motor1, shooter_motor2);

  public PWMVictorSPX elevator_motor1 = new PWMVictorSPX(12);
  public PWMVictorSPX elevator_motor2 = new PWMVictorSPX(13);
  public SpeedControllerGroup elevator_motors = new SpeedControllerGroup(elevator_motor1, elevator_motor2);

  public Solenoid solenoid = new Solenoid(0);

  public Timer timer = new Timer();

  //public Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);
  public AnalogGyro gyro = new AnalogGyro(0);

  public Ultrasonic ultrasonic = new Ultrasonic(13, 14);

  public boolean elevetor_open = false;
  public boolean is_elevator_up = false;
  public boolean shooter_open = false;
  public boolean is_shooter_cover_up = false;

  public double target_angle = 90;

  public double ultrasonic_output_cm;

  public int auto_level = 1;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    left_encoder.setDistancePerPulse ((2*Math.PI*wheelRad/left_encoder_pulse)*2.54);
    right_encoder.setDistancePerPulse((2*Math.PI*wheelRad/right_encoder_pulse)*2.54);
    
    left_encoder.reset();
    right_encoder.reset();
    timer.reset();
    gyro.reset();

    Ultrasonic.setAutomaticMode(true);
  }


  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
    ultrasonic_output_cm = ultrasonic.getRangeInches()*2.54;
  }

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
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
          if(auto_level == 1){
            if(left_encoder.getDistance()<200 && right_encoder.getDistance()<200){
              drive.tankDrive(0.7, 0.7);
            }
            else{
              auto_level = 2;
            }
          }
          else if(auto_level == 2){
            double error = target_angle - gyro.getAngle();
            double wheel_speed = error/100;
            if(gyro.getAngle() <=90){
              right_motors.set(wheel_speed);
              left_motors.set(0);
            }
            else{
              auto_level = 3;
            }
          }
          else if(auto_level ==3){
            if(ultrasonic_output_cm > 10){
              drive.tankDrive(0.7, 0.7);
            }
            else{
              drive.tankDrive(0.0, 0.0);
              auto_level = 0;
            }
          }
      break;


      case kDefaultAuto:
          default:
            if(left_encoder.getDistance()<500 && right_encoder.getDistance()<500){
              drive.tankDrive(0.7, 0.7);
            }
            else{
              drive.tankDrive(0.0, 0.0);
            }
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    timer.reset();
  }


  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    SmartDashboard.putNumber("Sol Encoder", left_encoder.getDistance());
    SmartDashboard.putNumber("Sağ Encoder", right_encoder.getDistance());
    SmartDashboard.putNumber("gyro", gyro.getAngle());
    SmartDashboard.putNumber("ultrasonic", ultrasonic_output_cm);

    drive.tankDrive(joystick.getRawAxis(1), joystick.getRawAxis(3));

    left_motors.set (joystick.getRawAxis(1));
    right_motors.set(joystick.getRawAxis(3));

    //ButtonX
    if(buttonX.get()){
      intake_motor.set(0.7);
    }
    else{
      intake_motor.set(0);
    }

    //ButtonY
    if(buttonY.get()){
      shooter_motors.set(0.8);
    }
    else{
      shooter_motors.set(0);
    }



    //ButtonA
    if(buttonA.get()){
      elevetor_open = true;
    }


    if(elevetor_open && is_elevator_up == false){
      timer.start();
        if (timer.get() < 5) {
          elevator_motors.set(0.8);
        }
        else{
          elevator_motors.set(0);
          is_elevator_up = true;
          timer.stop();
          timer.reset();
          elevetor_open = false;
        }
    }


    else if(elevetor_open && is_elevator_up == true){
      timer.start();
        if (timer.get() < 5) {
          elevator_motors.set(-0.8);
        }
        else{
          elevator_motors.set(0);
          is_elevator_up = false;
          timer.stop();
          timer.reset();
          elevetor_open = false;
        }
    }



    //ButtonB
    if(buttonB.get()){
      shooter_open = true;
    }


    if(shooter_open && is_shooter_cover_up == false){
      solenoid.set(true);
      is_shooter_cover_up = true;

      shooter_open = false;
    }


    else if(shooter_open && is_shooter_cover_up == true){
      solenoid.set(false);
      is_shooter_cover_up = false;

      shooter_open = false;
    }



  }

}
