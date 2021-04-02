
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.RobotFeatures;

public class DriveSubsystem extends SubsystemBase {

    private final PWMVictorSPX leftFront   = new PWMVictorSPX(Constants.RoboRIOPWMPorts.driveLeft1);
    private final PWMVictorSPX leftMiddle  = new PWMVictorSPX(Constants.RoboRIOPWMPorts.driveLeft2);
    private final PWMVictorSPX leftBack    = new PWMVictorSPX(Constants.RoboRIOPWMPorts.driveLeft3);
    private final PWMVictorSPX rightFront  = new PWMVictorSPX(Constants.RoboRIOPWMPorts.driveRight1);
    private final PWMVictorSPX rightMiddle = new PWMVictorSPX(Constants.RoboRIOPWMPorts.driveRight1);
    private final PWMVictorSPX rightBack   = new PWMVictorSPX(Constants.RoboRIOPWMPorts.driveRight1);

    private final SpeedControllerGroup left  = new SpeedControllerGroup(leftFront, leftMiddle, leftBack);
    private final SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightMiddle, rightBack);

    private final DifferentialDrive drive = new DifferentialDrive(left, right);

    private final Encoder leftEncoder  = new Encoder(Constants.RoboRIOAnalogPorts.driveEncoder1, Constants.RoboRIOAnalogPorts.driveEncoder2);
    private final Encoder rightEncoder = new Encoder(Constants.RoboRIOAnalogPorts.driveEncoder3, Constants.RoboRIOAnalogPorts.driveEncoder4);

    private final AnalogGyro gyro = new AnalogGyro(Constants.RoboRIOAnalogPorts.driveGyro);


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
    leftEncoder.setDistancePerPulse((2*Math.PI*Constants.RobotFeatures.wheelRadius/RobotFeatures.encoderPPR)*2.54);
    return leftEncoder.getDistance();
  }

  public double getDistanceRight(){
    rightEncoder.setDistancePerPulse((2*Math.PI*Constants.RobotFeatures.wheelRadius/RobotFeatures.encoderPPR)*2.54);
    return rightEncoder.getDistance();
}

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
