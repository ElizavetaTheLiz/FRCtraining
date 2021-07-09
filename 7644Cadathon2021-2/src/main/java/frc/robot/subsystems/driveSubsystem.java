// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
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
import frc.robot.Constants;

public class driveSubsystem extends SubsystemBase {

  private final PWMVictorSPX motor_left1 = new PWMVictorSPX(0);
  private final PWMVictorSPX motor_left2 = new PWMVictorSPX(0);
  private final PWMVictorSPX motor_right1 = new PWMVictorSPX(0);
  private final PWMVictorSPX motor_right2 = new PWMVictorSPX(0);

  //private int leftOffset = 0;
  //private int rightOffset = 0;
  private final AnalogGyro gyro = new AnalogGyro(0);
  //private final double distancePerPulse = (2.0 * 0 * 0) /(0);

  private final SpeedControllerGroup left = new SpeedControllerGroup(motor_left1, motor_left2);
  private final SpeedControllerGroup right = new SpeedControllerGroup(motor_right1, motor_right2);
  private final DifferentialDrive drive = new DifferentialDrive(left, right);

  private final Encoder leftEncoder = new Encoder(0,0);
  private final Encoder rightEncoder = new Encoder(0,0);


  private Pose2d pose = new Pose2d(Constants.autonomous.Pose2d_Axis_X, Constants.autonomous.Pose2d_Axis_Y, new Rotation2d());

  private final DifferentialDriveOdometry odometry      = new DifferentialDriveOdometry(getGyroHeading(), pose);
  private final DifferentialDriveKinematics kinematics  = new DifferentialDriveKinematics(Constants.robotFeatures.wheelTrack);
  private final SimpleMotorFeedforward motorFeedforward = new SimpleMotorFeedforward(
    Constants.characterization.kS, Constants.characterization.kV, Constants.characterization.kA);

  private final PIDController leftPidController = new PIDController(
    Constants.characterization.kP, Constants.characterization.kI, Constants.characterization.kD);

  private final PIDController rightPidController = new PIDController(
    Constants.characterization.kP, Constants.characterization.kI, Constants.characterization.kD);




  private static driveSubsystem INSTANCE = new driveSubsystem();

  public static driveSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (driveSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new driveSubsystem();
            }
        }
    }
    return INSTANCE;
}

  public void encoderReset(){
    leftEncoder.reset();
    rightEncoder.reset();
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

  
  public void setMotors(double leftSpeed, double rightSpeed){
    this.left.set (leftSpeed /12);
    this.right.set(rightSpeed/12);
  }


  public double getDistanceLeft(){
    leftEncoder.setDistancePerPulse((2*Math.PI*Constants.robotFeatures.wheelRadius/Constants.robotFeatures.encoderPPR)*2.54);
    return leftEncoder.getDistance();
  }

  public double getDistanceRight(){
    rightEncoder.setDistancePerPulse((2*Math.PI*Constants.robotFeatures.wheelRadius/Constants.robotFeatures.encoderPPR)*2.54);
    return rightEncoder.getDistance();
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
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



/*
  @Override
  public void initDefaultCommand() {
    setDefaultCommand((Command) new TankDrive());

  }
  public double getLeftDisctance(){
    return distancePerPulse * this.getLeftTicks();
  }

  public double getRightDisctance(){
    return distancePerPulse * this.getRightTicks();
  }
  
  public int getLeftTicks(){
    return ((Object) this.motor_left1).getSelectedSensorPosition() - this.leftOffset;
  }

  public int getRightTicks(){
    return ((Object) this.motor_right1).getSelectedSensorPosition() - this.rightOffset;
  }
  public void resetEncoders(){
    this.leftOffset = ((Object) this.motor_left1).getSelectedSensorPosition();
    this.rightOffset = ((Object) this.motor_right1).getSelectedSensorPosition();
  }
  */
}