package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ElevatorSubsystem extends SubsystemBase {

    private final PWMVictorSPX elevLeft  = new PWMVictorSPX(Constants.elevMotor);
    private final PWMVictorSPX elevRight = new PWMVictorSPX(Constants.elevMotor2);

    private final Encoder elevEncoder  = new Encoder(Constants.elevEncoderPort,Constants.elevEncoderPort2, true);

    private double aimedPosition = Constants.elevatorTopPosition;

    private final double error = aimedPosition - getEncoderPosition();
    private final double outputSpeed = Constants.elevKP * error;


    private static ElevatorSubsystem INSTANCE;
    public static ElevatorSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (ElevatorSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new ElevatorSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public ElevatorSubsystem() {
        elevLeft.setInverted(false);
        elevRight.setInverted(true);
    }


    public void moveElevator(boolean TrueTop_FalseDown){
        if(TrueTop_FalseDown){
            aimedPosition = Constants.elevatorTopPosition;
        }
        else {
            aimedPosition = Constants.elevatorDownPosition;
        }
        elevLeft.set(outputSpeed);
        elevRight.set(outputSpeed);
    }

    public double getEncoderPosition(){
        return elevEncoder.get() / (double)Constants.ElevEncoderPpr * Constants.elevatorRaising;
    }

    public void stopElevator(){
        elevLeft.set(0.0);
        elevRight.set(0.0);
    }

    public void resetElevEncoder(){
        elevEncoder.reset();
    }
}
