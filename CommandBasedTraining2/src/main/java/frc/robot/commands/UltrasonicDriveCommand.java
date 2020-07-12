package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.JoystickSubsystem;
import frc.robot.subsystems.UltrasonicSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class UltrasonicDriveCommand extends CommandBase{

 private final JoystickSubsystem joystick                 = new JoystickSubsystem();
    private final UltrasonicSubsystem ultrasonicSubsystem = UltrasonicSubsystem.getInstance();
    private final DriveSubsystem driveSubsystem           = DriveSubsystem.getInstance();
    boolean durum = false;


    public UltrasonicDriveCommand(){
        addRequirements(this.joystick, this.driveSubsystem, this.ultrasonicSubsystem);
    }

    @Override
    public void initialize() {
        ultrasonicSubsystem.ultrasonicCalisma(true);
    }

    @Override
    public void execute() {
        if (ultrasonicSubsystem.ultrasonicYolEngelsiz()){
            driveSubsystem.Drive(joystick.getRawAxis(Constants.Joystick_Connection.Axis1), joystick.getRawAxis(Constants.Joystick_Connection.Axis2));
        }
        else{
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
