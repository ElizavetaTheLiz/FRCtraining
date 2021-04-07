
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HangSubsystem extends SubsystemBase {

    private final PWMVictorSPX motor = new PWMVictorSPX(Constants.RoboRIOPWMPorts.hangMotor);
    private final Encoder encoder    = new Encoder(0, 0);

    
    private static HangSubsystem INSTANCE = new HangSubsystem();

    public static HangSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (HangSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new HangSubsystem();
              }
          }
      }
      return INSTANCE;
  }

  public void encoderReset(){
    encoder.reset();
  }

  public double encoderGetDegrees(){
    return encoder.get() *360 /Constants.RobotFeatures.encoderPPR;
  }

  public void motorOpenClose(double speed){
    motor.set(speed);
  }

  public void motorStop(){
      motor.set(0);
  }

  /** Creates a new HangSubsystem. */
  public HangSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}












