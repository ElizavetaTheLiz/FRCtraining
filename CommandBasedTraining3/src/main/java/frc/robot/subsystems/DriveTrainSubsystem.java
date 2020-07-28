package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class DriveTrainSubsystem extends PIDSubsystem {

    private final PWMVictorSPX leftFront  = new PWMVictorSPX(Constants.motor1);
    private final PWMVictorSPX leftBack   = new PWMVictorSPX(Constants.motor2);
    private final PWMVictorSPX rightFront = new PWMVictorSPX(Constants.motor3);
    private final PWMVictorSPX rightBack  = new PWMVictorSPX(Constants.motor4);

    private final SpeedControllerGroup left  = new SpeedControllerGroup(leftFront, leftBack);
    private final SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack);

    private final DifferentialDrive differentialDrive = new DifferentialDrive(left, right);

    private final Encoder driveEncoderLeft  = new Encoder(Constants.leftEncoderPort,  Constants.leftEncoderPort2, true);
    private final Encoder driveEncoderRight = new Encoder(Constants.rightEncoderPort,Constants.rightEncoderPort2, false);

    private static DriveTrainSubsystem INSTANCE;
    public static DriveTrainSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (DriveTrainSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new DriveTrainSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public void resetDriveEncoders(){
        driveEncoderLeft.reset();
        driveEncoderRight.reset();
    }

    public DriveTrainSubsystem() {
        super(new PIDController(Constants.kP, Constants.kI, Constants.kD));
        left.setInverted(false);
        right.setInverted(true);
        driveEncoderLeft .setDistancePerPulse(Constants.leftDistancePerPulse);
        driveEncoderRight.setDistancePerPulse(Constants.rightDistancePerPulse);
        setSetpoint(Constants.driveTargetRPS);
    }

    public void drive(double leftSpeed, double rightSpeed){
        differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public void useOutput(double output, double setpoint) {
        left.setVoltage (output);
        right.setVoltage(output);
    }

    @Override
    protected double getMeasurement() {
        return driveEncoderLeft.getRate();
    }


    public boolean atSetpoint() {
        return m_controller.atSetpoint();
    }
}
