// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

public class joystickSubsystem extends SubsystemBase {

    private final Joystick joystick = new Joystick(Constants.IO.joystickPort);
    private final JoystickButton button = new JoystickButton(joystick, Constants.IO.buttonNumber);


    private static joystickSubsystem INSTANCE = new joystickSubsystem();

    public static joystickSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (joystickSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new joystickSubsystem();
              }
          }
      }
      return INSTANCE;
  }
  

  /** Creates a new ExampleSubsystem. */
  public joystickSubsystem() {}


  public double getRawAxis(int axisNum){
      return joystick.getRawAxis(axisNum);
  }

}
