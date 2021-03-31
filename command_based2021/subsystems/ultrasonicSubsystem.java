// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ultrasonicSubsystem extends SubsystemBase {

    private final Ultrasonic ultrasonic = new Ultrasonic(Constants.AnalogPorts.sonic1, Constants.AnalogPorts.sonic2);


    private static ultrasonicSubsystem INSTANCE = new ultrasonicSubsystem();
    public static ultrasonicSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (ultrasonicSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new ultrasonicSubsystem();
                }
            }
        }
        return INSTANCE;
    }

  /** Creates a new ExampleSubsystem. */
  public ultrasonicSubsystem() {}


  public void ac_kapat(boolean ac_kapat){
     ultrasonic.setAutomaticMode(ac_kapat);
  }

  public boolean engel_var_mi(double aimedCm){
    double kalanCm = ultrasonic.getRangeInches() * 2.54;
    return kalanCm < aimedCm;
  }
}