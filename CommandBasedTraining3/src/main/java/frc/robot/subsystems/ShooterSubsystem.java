package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private final PWMVictorSPX shooterMotor = new PWMVictorSPX(Constants.shooterMotor);
    private final Encoder shooterEncoder    = new Encoder(Constants.shootEncoderPort,Constants.shootEncoderPort2,true);

    private static ShooterSubsystem INSTANCE;
    public static ShooterSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (ShooterSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new ShooterSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public ShooterSubsystem(){
        shooterEncoder.setDistancePerPulse(1.0 / (Constants.ShootEncoderPpr));
    }

    public void runShooter(double speed){
        shooterMotor.set(speed);
    }

    public void shooterBack(boolean doUWantItToWork){
        if(doUWantItToWork){
            shooterMotor.set(0.1);
        }
        else {
            shooterMotor.set(0.);
        }
    }

    public double getRPM() {
        return shooterEncoder.getRate() * 60;
    }
}
