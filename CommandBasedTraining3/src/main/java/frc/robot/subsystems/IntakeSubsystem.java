package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final PWMVictorSPX intakeMotor  = new PWMVictorSPX(Constants.intakeMotor);

    private static IntakeSubsystem INSTANCE;
    public static IntakeSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (IntakeSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new IntakeSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public void intakePos(boolean doUWantItToWork){
        if(doUWantItToWork){
            intakeMotor.set(0.8);
        }
        else {
            intakeMotor.set(0.);
        }
    }

}
