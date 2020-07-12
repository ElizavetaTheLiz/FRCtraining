package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EncoderSubsystem extends SubsystemBase{
    private final Encoder encoder = new Encoder(Constants.RoboRIO_Sensor_Ports.port3, Constants.RoboRIO_Sensor_Ports.port4);


    private static EncoderSubsystem INSTANCE = new EncoderSubsystem();
    public static EncoderSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (EncoderSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new EncoderSubsystem();
                }
            }
        }
        return INSTANCE;
    }


    public EncoderSubsystem(){

    }

    public void reset (){
        encoder.reset();
    }

    public double distance() {
        return encoder.getDistance();
    }
}
