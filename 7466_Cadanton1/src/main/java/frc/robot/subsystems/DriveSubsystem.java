//TODO check motors invert situation, did you set booleans right?
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {

    private final PWMVictorSPX leftFront     = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.MasterMotor1);
    private final PWMVictorSPX leftBack      = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.MasterMotor2);
    //public final PWMVictorSPX leftMid      = new PWMVictorSPX();
    private final SpeedControllerGroup left  = new SpeedControllerGroup(leftFront,leftBack/*,leftMid*/);
    private final PWMVictorSPX rightFront    = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.MasterMotor3);
    private final PWMVictorSPX rightBack     = new PWMVictorSPX(Constants.RoboRIO_PWM_Channels.MasterMotor4);
    //public final PWMVictorSPX rightMid     = new PWMVictorSPX();
    private final SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack/*,rightMid*/);

    private final DifferentialDrive drivetrain = new DifferentialDrive(left, right);

    private final Encoder leftEncoder  = new Encoder(Constants.RoboRIO_DIO_Channels.leftEncoder,Constants.RoboRIO_DIO_Channels.leftEncoder2);
    private final Encoder rightEncoder = new Encoder(Constants.RoboRIO_DIO_Channels.rightEncoder,Constants.RoboRIO_DIO_Channels.rightEncoder2);

    private final GyroSubsystem gyroSubsystem = GyroSubsystem.getInstance();


    SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(
            Constants.fixed.kS, Constants.fixed.kV, Constants.fixed.kA);

    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(
            Constants.RobotFeatures.trackWidth);

    DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(gyroSubsystem.getHeading(), new Pose2d(0,0, new Rotation2d()));
    //TODO: Create a connection between kinematics and odometry classes

    Pose2d pose;

    PIDController leftPIDController = new PIDController(
            Constants.fixed.kP, Constants.fixed.kI, Constants.fixed.kD);
    PIDController rightPIDController = new PIDController(
            Constants.fixed.kP, Constants.fixed.kI, Constants.fixed.kD);

    private static DriveSubsystem INSTANCE;
    public static DriveSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (DriveSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new DriveSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    public Rotation2d getHeading(){
        return Rotation2d.fromDegrees(-gyroSubsystem.getAngle());
    }

    public void Drive(double left, double right) {
        drivetrain.tankDrive(left, -right);
    }

    public void encoderReset(){
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public PIDController getLeftPIDController(){
        return leftPIDController;
    }

    public PIDController getRightPIDController(){
        return rightPIDController;
    }

    public double getLeftDistance() {
        leftEncoder.setDistancePerPulse(
                Constants.RobotFeatures.leftEncoderDistancePerPulse/Constants.RobotFeatures.leftEncoderPpr);
        return leftEncoder.getDistance();
    }

    public double getRightDistance() {
        rightEncoder.setDistancePerPulse(
                Constants.RobotFeatures.rightEncoderDistancePerPulse/Constants.RobotFeatures.rightEncoderPpr);
        return rightEncoder.getDistance();
    }

    public SimpleMotorFeedforward getFeedforward(){
        return feedforward;
    }


    @Override
    public void periodic() {
        pose = odometry.update(gyroSubsystem.getHeading(), getLeftDistance(), getRightDistance());
    }
}