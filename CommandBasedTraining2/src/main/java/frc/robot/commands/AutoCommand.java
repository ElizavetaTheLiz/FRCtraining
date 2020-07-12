package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.EncoderSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.UltrasonicSubsystem;
import frc.robot.subsystems.JoystickSubsystem;

public class AutoCommand extends CommandBase{
    boolean durum = false;

    private final EncoderSubsystem encoderSubsystem       = EncoderSubsystem.getInstance();
    private final DriveSubsystem driveSubsystem           = DriveSubsystem.getInstance();
    private final UltrasonicSubsystem ultrasonicSubsystem = UltrasonicSubsystem.getInstance();
    private final JoystickSubsystem joystick              = JoystickSubsystem.getInstance();

    public AutoCommand(){
        addRequirements(this.encoderSubsystem, this.driveSubsystem, this.ultrasonicSubsystem, this.joystick);
    }

    @Override
    public void initialize() {
        encoderSubsystem.reset();
        ultrasonicSubsystem.ultrasonicCalisma(true);
    }

    @Override
    public void execute() {
        if ((encoderSubsystem.distance() < 5) && ultrasonicSubsystem.ultrasonicYolEngelsiz()){
            driveSubsystem.Drive(joystick.getRawAxis(Constants.Joystick_Connection.Axis1), joystick.getRawAxis(Constants.Joystick_Connection.Axis2));
        }
        else {
            durum = true;
        }
    }

    @Override
    public boolean isFinished() {
        return durum;
    }

    @Override
    public void end(boolean interrupted) {

    }

}
