package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class UltrasonicSubsystem extends SubsystemBase {

    Ultrasonic ultrasonic = new Ultrasonic(Constants.RoboRIO_Sensor_Ports.port1, Constants.RoboRIO_Sensor_Ports.port2);


    private static UltrasonicSubsystem INSTANCE = new UltrasonicSubsystem();
    public static UltrasonicSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (UltrasonicSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new UltrasonicSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public UltrasonicSubsystem() {
    }


    public void ultrasonicCalisma(boolean ac_kapa){
        ultrasonic.setAutomaticMode(ac_kapa);
    }

    public boolean ultrasonicYolEngelsiz() {
        return ultrasonic.getRangeInches() > 4;
    }
}
