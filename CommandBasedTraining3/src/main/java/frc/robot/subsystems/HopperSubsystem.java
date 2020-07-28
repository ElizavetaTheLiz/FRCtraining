package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem extends SubsystemBase {

    private final PWMVictorSPX hopperMotor  = new PWMVictorSPX(Constants.hopperMotor);

    private static HopperSubsystem INSTANCE;
    public static HopperSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (HopperSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new HopperSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public void hopperPos(boolean doUWantItToWork){
        if(doUWantItToWork){
            hopperMotor.set(0.8);
        }
        else {
            hopperMotor.set(0.);
        }
    }

}
