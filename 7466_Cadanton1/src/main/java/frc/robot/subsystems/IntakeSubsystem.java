package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final PWMVictorSPX IntakeMotorLeft    = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.IntakeMotor1);
    private final PWMVictorSPX IntakeMotorRight   = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.IntakeMotor2);
    private final PWMVictorSPX IntakeMotorTurning = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.IntakeMotorTurning);

    private final Encoder IntakeEncoder = new Encoder(Constants.RoboRIO_DIO_Channels.intakeEncoder, Constants.RoboRIO_DIO_Channels.intakeEncoder2);

    private final double error = Constants.RobotFeatures.intakeAngle - getAngle();
    private final double outputSpeed = Constants.fixed.intakeKP * error;

    private static IntakeSubsystem INSTANCE;
    public static IntakeSubsystem getInstance() {
        if (INSTANCE == null) {
            synchronized (IntakeSubsystem.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IntakeSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    private IntakeSubsystem() {
    }

    public void TurnOn(){
        IntakeMotorTurning.set(0.7);
    }

    public void TurnBack(){
        IntakeMotorTurning.set(-0.7);
    }

    public void Intake_Take_the_Object(){
        IntakeMotorLeft.setInverted(false);
        IntakeMotorRight.setInverted(true);
        IntakeMotorLeft.set(0.7);
        IntakeMotorRight.set(0.7);
    }

    public void Intake_Leave_the_Object(){
        IntakeMotorLeft.setInverted(false);
        IntakeMotorRight.setInverted(true);
        IntakeMotorLeft.set(-0.7);
        IntakeMotorRight.set(-0.7);
    }

    public void IntakeStop(){
        IntakeMotorLeft.setInverted(false);
        IntakeMotorRight.setInverted(true);
        IntakeMotorLeft.set(0);
        IntakeMotorRight.set(0);
    }

    public void ResetEncoder(){
        IntakeEncoder.reset();
    }

    public double getRate(){
        return IntakeEncoder.getRate();
    }

    public double getAngle(){
        return IntakeEncoder.get() / (double)Constants.RobotFeatures.intakeEncoderPpr * 360;
    }

    public void turnTheIntake(double motorSpeed){
        this.IntakeMotorTurning.set(motorSpeed);
    }

    public double getOutputSpeed(){
        return outputSpeed;
    }

}
