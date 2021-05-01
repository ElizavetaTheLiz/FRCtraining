
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.Constants.robotFeatures;

public class DriveSubsystem extends SubsystemBase {

    private final PWMVictorSPX leftFront        = new PWMVictorSPX(Constants.roboRIOPWMPorts.driveLeft1);
    private final PWMVictorSPX leftMiddle       = new PWMVictorSPX(Constants.roboRIOPWMPorts.driveLeft2);
    private final PWMVictorSPX rightFront       = new PWMVictorSPX(Constants.roboRIOPWMPorts.driveRight1);
    private final PWMVictorSPX rightMiddle      = new PWMVictorSPX(Constants.roboRIOPWMPorts.driveRight2);

    private final SpeedControllerGroup left     = new SpeedControllerGroup(leftFront, leftMiddle);
    private final SpeedControllerGroup right    = new SpeedControllerGroup(rightFront, rightMiddle);
    private final DifferentialDrive drive       = new DifferentialDrive(left, right);

    private final Encoder leftEncoder           = new Encoder(Constants.roboRIODigitalPorts.driveEncoder1, Constants.roboRIODigitalPorts.driveEncoder2);
    private final Encoder rightEncoder          = new Encoder(Constants.roboRIODigitalPorts.driveEncoder3, Constants.roboRIODigitalPorts.driveEncoder4);
    private final AnalogGyro gyro               = new AnalogGyro(Constants.roboRIOAnalogPorts.driveGyro);

    private final Joystick joystick             = new Joystick(Constants.joystick.joystickPort);
    private final JoystickButton buttonX        = new JoystickButton(joystick, 0);
    private final JoystickButton buttonA        = new JoystickButton(joystick, 1);
    private final JoystickButton buttonB        = new JoystickButton(joystick, 2);
    private final JoystickButton buttonY        = new JoystickButton(joystick, 3);    
    private final JoystickButton buttonLeft     = new JoystickButton(joystick, 4);
    private final JoystickButton buttonRight    = new JoystickButton(joystick, 5);
    private final JoystickButton buttonTopLeft  = new JoystickButton(joystick, 6);
    private final JoystickButton buttonBack     = new JoystickButton(joystick, 8);
    private final JoystickButton buttonStart    = new JoystickButton(joystick, 9);
    private final JoystickButton buttonBigLeft  = new JoystickButton(joystick, 10);
    private final JoystickButton buttonBigRight = new JoystickButton(joystick, 11);

    private Pose2d pose = new Pose2d(Constants.autonomous.Pose2d_Axis_X, Constants.autonomous.Pose2d_Axis_Y, new Rotation2d());

    private final DifferentialDriveOdometry odometry      = new DifferentialDriveOdometry(getGyroHeading(), pose);
    private final DifferentialDriveKinematics kinematics  = new DifferentialDriveKinematics(Constants.robotFeatures.wheelTrack);
    private final SimpleMotorFeedforward motorFeedforward = new SimpleMotorFeedforward(
      Constants.characterization.kS, Constants.characterization.kV, Constants.characterization.kA);

    private final PIDController leftPidController = new PIDController(
      Constants.characterization.kP, Constants.characterization.kI, Constants.characterization.kD);

    private final PIDController rightPidController = new PIDController(
      Constants.characterization.kP, Constants.characterization.kI, Constants.characterization.kD);


    private static DriveSubsystem INSTANCE = new DriveSubsystem();

    public static DriveSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (DriveSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new DriveSubsystem();
              }
          }
      }
      return INSTANCE;
  }

  public void drive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void encoderReset(){
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getDistanceLeft(){
    leftEncoder.setDistancePerPulse((2*Math.PI*Constants.robotFeatures.wheelRadius/robotFeatures.encoderPPR)*2.54);
    return leftEncoder.getDistance();
  }

  public double getDistanceRight(){
    rightEncoder.setDistancePerPulse((2*Math.PI*Constants.robotFeatures.wheelRadius/robotFeatures.encoderPPR)*2.54);
    return rightEncoder.getDistance();
  }

  public Pose2d getPose2d(){
    return pose;
  }

  public PIDController getLeftPID(){
    return leftPidController;
  }

  public PIDController getRighPID(){
    return rightPidController;
  }

  public Rotation2d getGyroHeading(){
    return Rotation2d.fromDegrees(-gyro.getAngle());
  }


  public DifferentialDriveKinematics getKinematics(){
    return kinematics;
  }

  public SimpleMotorFeedforward getMotorFeedforward(){
    return motorFeedforward;
  }

  public DifferentialDriveWheelSpeeds getWheelSpeeds(){
    return new DifferentialDriveWheelSpeeds(leftEncoder.getRate(), rightEncoder.getRate());
  }

  public Joystick getJoystick(){
    return joystick;
  }

  public JoystickButton getJoystickButtonX(){
    return buttonX;
  }

  public JoystickButton getJoystickButtonY(){
    return buttonY;
  }

  public JoystickButton getJoystickButtonA(){
    return buttonA;
  }

  public JoystickButton getJoystickButtonB(){
    return buttonB;
  }

  public JoystickButton getJoystickButtonStart(){
    return buttonStart;
  }

  public JoystickButton getJoystickButtonBack(){
    return buttonBack;
  }

  public JoystickButton getJoystickButtonLeft(){
    return buttonLeft;
  }

  public JoystickButton getJoystickButtonRight(){
    return buttonRight;
  }

  public JoystickButton getJoystickButtonTopLeft(){
    return buttonTopLeft;
  }

  public JoystickButton getJoystickButtonBigLeft(){
    return buttonBigLeft;
  }

  public JoystickButton getJoystickButtonBigRight(){
    return buttonBigRight;
  }

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    encoderReset();
  }


  public void setMotors(double leftSpeed, double rightSpeed){
    this.left.set (leftSpeed /12);
    this.right.set(rightSpeed/12);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    var gyroAngle = Rotation2d.fromDegrees(-gyro.getAngle());

    pose = odometry.update(gyroAngle, leftEncoder.getDistance(), rightEncoder.getDistance());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
