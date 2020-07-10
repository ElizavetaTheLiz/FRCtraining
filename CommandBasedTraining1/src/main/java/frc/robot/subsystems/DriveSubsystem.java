package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;


public class DriveSubsystem extends SubsystemBase{

    private final PWMVictorSPX frontLeft_VictorSPX = new PWMVictorSPX(1);
    private final PWMVictorSPX frontRight_VictorSPX = new PWMVictorSPX(2);
    private final PWMVictorSPX backLeft_VictorSPX = new PWMVictorSPX(3);
    private final PWMVictorSPX backRight_VictorSPX = new PWMVictorSPX(4);


    private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeft_VictorSPX, backLeft_VictorSPX);
    private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRight_VictorSPX, backRight_VictorSPX);
    private final DifferentialDrive m_Drive = new DifferentialDrive(leftMotors, rightMotors);


    /*private double scaleLeft(double left){
        return 0.2 * left;
    }
    private double scaleRight(double right){
        return 0.2 * right;
    }
    public void setMotors(double left, double right){
        left = scaleLeft(left);
        right = scaleRight(right);
        leftMotors.set(left);
        rightMotors.set(right);
    }*/


    public void Drive(double left, double right){
        m_Drive.tankDrive(-left, -right);
    }


    private static DriveSubsystem INSTANCE = new DriveSubsystem();
    public static DriveSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (MotorSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new DriveSubsystem();
                }
            }
        }
        return INSTANCE;
    }


    public DriveSubsystem() {
    }


    @Override
    public void periodic () {

    }
}
