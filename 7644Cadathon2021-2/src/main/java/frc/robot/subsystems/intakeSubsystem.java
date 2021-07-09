package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intakeSubsystem extends SubsystemBase{
    

    private final PWMVictorSPX intake_redline_motor1 = new PWMVictorSPX(0);
    private final PWMVictorSPX intake_redline_motor2 = new PWMVictorSPX(1);

    private final PWMVictorSPX intake_turn_180_motor = new PWMVictorSPX(2);

    private final Encoder encoder = new Encoder(0, 0);

    private final SpeedControllerGroup intake_redline_motors = new SpeedControllerGroup(intake_redline_motor1, intake_redline_motor2);


private static intakeSubsystem INSTANCE = new intakeSubsystem();

    public static intakeSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (intakeSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new intakeSubsystem();
              }
          }
      }
      return INSTANCE;
  }


    public void stop_intake_motors(){
        intake_redline_motors.set(0);
    }   

    public void open_intake_motors(double speed){
        if(speed<=0){
            intake_redline_motors.set(0);
        }

        else{
            intake_redline_motors.set(speed);
        }
        
    }

    public void stop180Turning(){
        intake_turn_180_motor.set(0);
    }

    public void intakeTurn(double speed){
        if(speed>0){
        intake_turn_180_motor.set(speed);
        }

        else{
            intake_turn_180_motor.set(0);
        }
    }

    public void intakeTurnBack(double speed){
        if(speed<0){
        intake_turn_180_motor.set(speed);
        }

        else{
            intake_turn_180_motor.set(0);
        }
    }

    public void reset_encoder(){
        encoder.reset();
    }

    public double getEncoderDegree(){
        encoder.setDistancePerPulse(360/Constants.encoder.encoderPPR);
        return encoder.getDistance();
    }

}