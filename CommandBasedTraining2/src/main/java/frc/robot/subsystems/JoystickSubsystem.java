package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

public class JoystickSubsystem extends SubsystemBase{
public static Joystick Stick = new Joystick(Constants.Joystick_Connection.JoystickPort);
public static JoystickButton button1 = new JoystickButton(Stick, Constants.Joystick_Connection.Button1);



    private static JoystickSubsystem INSTANCE = new JoystickSubsystem();

    public static JoystickSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (JoystickSubsystem.class) {
                if (INSTANCE == null){
                    INSTANCE = new JoystickSubsystem();
                }
            }
        }
        return INSTANCE;
    }


    public JoystickSubsystem(){
    }

    public double getRawAxis(int number){
        return Stick.getRawAxis(number);
    }
}
