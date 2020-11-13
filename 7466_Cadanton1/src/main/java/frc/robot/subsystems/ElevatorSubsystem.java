package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.controller.ElevatorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.controller.PIDController;


public class ElevatorSubsystem extends PIDSubsystem {
    private final PWMVictorSPX ElevatorMotorLeft   = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.ElevatorMotorLeft);
    private final PWMVictorSPX ElevatorMotorLeft2  = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.ElevatorMotorLeft2);
    private final PWMVictorSPX ElevatorMotorRight  = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.ElevatorMotorRight);
    private final PWMVictorSPX ElevatorMotorRight2 = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.ElevatorMotorRight2);
    private final Encoder ElevatorEncoder = new Encoder(
            //TODO: set a boolean for each encoder in the code to express the reverse direction
            Constants.RoboRIO_DIO_Channels.elevEncoder, Constants.RoboRIO_DIO_Channels.elevEncoder2, true);

    private final ElevatorFeedforward elevatorFeedforward = new ElevatorFeedforward(
            Constants.fixed.elevKS ,Constants.fixed.elevKG, Constants.fixed.elevKV, Constants.fixed.elevKA);

    public ElevatorSubsystem() {
        super(new PIDController(Constants.fixed.elevKP, Constants.fixed.elevKI, Constants.fixed.elevKD));
        getController().setTolerance(Constants.fixed.elevToleranceRPS);
        ElevatorEncoder.setDistancePerPulse(Constants.RobotFeatures.elevEncoderDistancePerPulse);
        setSetpoint(Constants.fixed.elevSetpointRPS);
        //TODO: ask Baran about inverters and their usage in this constructor
        ElevatorMotorLeft.setInverted(false);
        ElevatorMotorLeft2.setInverted(false);
        ElevatorMotorRight.setInverted(true);
        ElevatorMotorRight2.setInverted(true);
    }

    @Override
    public void useOutput(double output, double setpoint) {
        ElevatorMotorLeft.setVoltage  (output + elevatorFeedforward.calculate(setpoint));
        ElevatorMotorLeft2.setVoltage (output + elevatorFeedforward.calculate(setpoint));
        ElevatorMotorRight.setVoltage (output + elevatorFeedforward.calculate(setpoint));
        ElevatorMotorRight2.setVoltage(output + elevatorFeedforward.calculate(setpoint));
    }

    @Override
    public double getMeasurement() {
        return ElevatorEncoder.getRate();
    }

    public boolean atSetpoint() {
        return m_controller.atSetpoint();
    }

    private static ElevatorSubsystem INSTANCE;
    public static ElevatorSubsystem getInstance() {
        if (INSTANCE == null) {
            synchronized (ElevatorSubsystem.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ElevatorSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public void elevatorUp(){
        ElevatorMotorLeft.set(0.7);
        ElevatorMotorLeft2.set(0.7);
        ElevatorMotorRight.set(0.7);
        ElevatorMotorRight2.set(0.7);
    }

    public void elevatorStop(){
        ElevatorMotorLeft.set(0.0);
        ElevatorMotorLeft2.set(0.0);
        ElevatorMotorRight.set(0.0);
        ElevatorMotorRight2.set(0.0);
    }

    public void elevatorDown(){
        ElevatorMotorLeft.set(-0.7);
        ElevatorMotorLeft2.set(-0.7);
        ElevatorMotorRight.set(-0.7);
        ElevatorMotorRight2.set(-0.7);
    }

    public ElevatorFeedforward getElevatorFeedforward(){
        return elevatorFeedforward;
    }

    public void ResetEncoder(){
        ElevatorEncoder.reset();
    }

    public double getRate(){
        return ElevatorEncoder.getRate();
    }

    public double getElevatorRaising() {
        return Constants.RobotFeatures.elevatorRaising / Constants.RobotFeatures.elevEncoderPpr * ElevatorEncoder.get();
    }
}