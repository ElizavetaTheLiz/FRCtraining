
  // Copyright (c) FIRST and other WPILib contributors.
  // Open Source Software; you can modify and/or share it under the terms of
  // the WPILib BSD license file in the root directory of this project.

  package frc.robot.subsystems;

  import edu.wpi.first.wpilibj.Encoder;
  import edu.wpi.first.wpilibj.PWMVictorSPX;
  import edu.wpi.first.wpilibj.SpeedControllerGroup;
  import edu.wpi.first.wpilibj2.command.SubsystemBase;
  import frc.robot.Constants;

  public class IntakeSubsystem extends SubsystemBase {
    /** Creates a new IntakeSubsystem. */

    private final PWMVictorSPX motor1 = new PWMVictorSPX(Constants.RoboRIOPWMPorts.intakeMotor1);
    private final PWMVictorSPX motor2 = new PWMVictorSPX(Constants.RoboRIOPWMPorts.intakeMotor2);
    private final PWMVictorSPX motor3 = new PWMVictorSPX(0);
    private final PWMVictorSPX motor4 = new PWMVictorSPX(0);

    private final SpeedControllerGroup inOutMotors = new SpeedControllerGroup(motor1, motor2);  
    private final SpeedControllerGroup Turn180Motors = new SpeedControllerGroup(motor3, motor4);  

    private final Encoder encoder = new Encoder(0, 0);

      
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

  public void encoderReset(){
    encoder.reset();
  }

  public double encoderGetDegrees(){
    return encoder.get() *360 /Constants.RobotFeatures.encoderPPR;
  }

  public void motorOpenClose(double speed){
    inOutMotors.set(speed);
  }

  public void motorStop(){
    inOutMotors.set(0);
  }
 
  public void intakeTurn(double speed){
    if(speed > 0){    
      Turn180Motors.set(speed);
    }
  }

  public void intakeTurnBack(double speed){
    if(speed < 0){    
      Turn180Motors.set(speed);
    }
  }

  public void intakeTurnStop(){   
      Turn180Motors.set(0);
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
