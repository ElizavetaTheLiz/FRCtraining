package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangSubsystem extends SubsystemBase {
    private final PWMVictorSPX hangMotor = new PWMVictorSPX(0);

    private static HangSubsystem INSTANCE;
    public static HangSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (HangSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new HangSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public void hangOpen(){
        hangMotor.set(0.7);
    }

    public void hangClose(){
        hangMotor.set(-0.7);
    }

    public void hangStop(){
        hangMotor.set(0.0);
    }
}
