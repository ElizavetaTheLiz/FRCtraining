
package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;


public class MotorSubsystem extends SubsystemBase{
    private final static PWMVictorSPX m_motor = new PWMVictorSPX(0);

    private static MotorSubsystem INSTANCE;

    public static MotorSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (MotorSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new MotorSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public MotorSubsystem()
    {

    }

    public void motorcalistirma(double hiz){
        m_motor.set(hiz);
    }

    @Override
    public void periodic()
    {

    }

}

