// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class redlineSubsystem extends SubsystemBase {

    private final PWMVictorSPX redline = new PWMVictorSPX(Constants.PWMPorts.redline);


    private static redlineSubsystem INSTANCE = new redlineSubsystem();
    public static redlineSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (redlineSubsystem.class) {
                if (INSTANCE == null){
                    INSTANCE = new redlineSubsystem();
                }
            }
        }
        return INSTANCE;
    }

  /** Creates a new ExampleSubsystem. */
  public redlineSubsystem() {}

  public void ac_kapat(boolean ac_kapat){
    if(ac_kapat){
        redline.set(Constants.Control.RedlineSpeed);
    }
    else{
        redline.set(0);
    }
  }

}
