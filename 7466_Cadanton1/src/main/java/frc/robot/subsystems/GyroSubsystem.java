package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class GyroSubsystem extends SubsystemBase {

    public final Gyro gyro = new ADXRS450_Gyro();

    private static GyroSubsystem INSTANCE;

    public static GyroSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (GyroSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new GyroSubsystem();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void periodic() {
    }

    public void gyroReset(){
        gyro.reset();
    }

    public double getAngle(){
        return gyro.getAngle();
    }

    public double getRate(){
        return gyro.getRate();
    }

    public Rotation2d getHeading(){
        return Rotation2d.fromDegrees(-gyro.getAngle());
    }

}