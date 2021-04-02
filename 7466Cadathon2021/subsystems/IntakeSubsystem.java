
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  private final PWMVictorSPX motor1 = new PWMVictorSPX(Constants.RoboRIOPWMPorts.intakeMotor1);
  private final PWMVictorSPX motor2 = new PWMVictorSPX(Constants.RoboRIOPWMPorts.intakeMotor2);

  private final SpeedControllerGroup motors = new SpeedControllerGroup(motor1, motor2);

    
  private static IntakeSubsystem INSTANCE = new IntakeSubsystem();

  public static IntakeSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (IntakeSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new IntakeSubsystem();
            }
        }
    }
    return INSTANCE;
}

public void motorOpenClose(double speed){
  motors.set(speed);
}

public void motorStop(){
    motors.set(0);
}

  public IntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
