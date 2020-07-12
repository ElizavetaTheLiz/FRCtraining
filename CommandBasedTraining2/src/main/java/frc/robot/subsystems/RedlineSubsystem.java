package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.Constants;


public class RedlineSubsystem extends SubsystemBase {

    private final PWMVictorSPX redlineSpx = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.Motorchannel5);
    private static RedlineSubsystem INSTANCE = new RedlineSubsystem();

    public static RedlineSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (RedlineSubsystem.class) {
                if (INSTANCE == null){
                    INSTANCE = new RedlineSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public RedlineSubsystem() {
    }

    public void redlineAc() {
        redlineSpx.set(0.7);
    }

    public void redlineKapat() {
        redlineSpx.set(0.0);
    }
}

