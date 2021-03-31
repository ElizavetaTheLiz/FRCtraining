// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class encoderSubsystem extends SubsystemBase {
    private final Encoder encoder = new Encoder(Constants.AnalogPorts.encoder1, Constants.AnalogPorts.encoder2, true);


    private static encoderSubsystem INSTANCE = new encoderSubsystem();

    public static encoderSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (encoderSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new encoderSubsystem();
              }
          }
      }
      return INSTANCE;
  }
  
  public void reset(){
      encoder.reset();
  }

  public double getDistance(){
      return encoder.getDistance();
  }

  public void setDistance(){
      encoder.setDistancePerPulse((2*Math.PI*Constants.RobotFeatures.wheelRadius/Constants.RobotFeatures.encoderPulse)*2.54);
  }

  /** Creates a new ExampleSubsystem. */
  public encoderSubsystem() {}

}
