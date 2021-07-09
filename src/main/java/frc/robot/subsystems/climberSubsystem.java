package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class climberSubsystem extends SubsystemBase{
    
    private final PWMVictorSPX climber_motor_1 = new PWMVictorSPX(0);
    private final PWMVictorSPX climber_motor_2 = new PWMVictorSPX(1);

    private final SpeedControllerGroup climber_motors = new SpeedControllerGroup(climber_motor_1, climber_motor_2);

    private final PWMVictorSPX gearbox_motor = new PWMVictorSPX(2);

    private final Encoder encoder = new Encoder(0, 0);

    private static climberSubsystem INSTANCE = new climberSubsystem();

    public static climberSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (climberSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new climberSubsystem();
              }
          }
      }
      return INSTANCE;
  }

  public void stopClimberMotors(){
      climber_motors.set(0);
  }

  public void openClimberMotors(double speed){
      climber_motors.set(speed);
  }

  public void stopGearboxMotors(){
      gearbox_motor.set(0);
  }

  public void openGearboxMotors(double speed){
      gearbox_motor.set(speed);
  }
    
  public void reset_encoder(){
      encoder.reset();
  }

  public double getEncoderDistance(){
    encoder.setDistancePerPulse(Constants.encoder.climberEncoderMovePerTour/Constants.encoder.encoderPPR);
    return encoder.getDistance();
  }

}
