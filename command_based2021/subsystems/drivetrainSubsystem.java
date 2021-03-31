// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drivetrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final PWMVictorSPX left_front  = new PWMVictorSPX(Constants.PWMPorts.motor1);
  private final PWMVictorSPX right_front = new PWMVictorSPX(Constants.PWMPorts.motor2);
  private final PWMVictorSPX left_back   = new PWMVictorSPX(Constants.PWMPorts.motor3);
  private final PWMVictorSPX right_back  = new PWMVictorSPX(Constants.PWMPorts.motor4);

  private final SpeedControllerGroup left  = new SpeedControllerGroup(left_front, left_back);
  private final SpeedControllerGroup right = new SpeedControllerGroup(right_front, right_back);

  private final DifferentialDrive drive = new DifferentialDrive(left, right);

  
  private static drivetrainSubsystem INSTANCE = new drivetrainSubsystem();

  public static drivetrainSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (drivetrainSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new drivetrainSubsystem();
            }
        }
    }
    return INSTANCE;
}



  public void TankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}
