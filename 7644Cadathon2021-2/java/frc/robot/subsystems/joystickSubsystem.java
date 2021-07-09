package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class joystickSubsystem extends SubsystemBase{

    private final Joystick joystick = new Joystick(0);

    private final JoystickButton buttonX = new JoystickButton(joystick, 0);
    private final JoystickButton buttonA = new JoystickButton(joystick, 1);
    private final JoystickButton buttonB = new JoystickButton(joystick, 2);
    private final JoystickButton buttonY = new JoystickButton(joystick, 3);    
    private final JoystickButton buttonLeft = new JoystickButton(joystick, 4);
    private final JoystickButton buttonRight = new JoystickButton(joystick, 5);
    private final JoystickButton buttonTopLeft = new JoystickButton(joystick, 6);
    private final JoystickButton buttonTopRight = new JoystickButton(joystick, 7);
    private final JoystickButton buttonBack = new JoystickButton(joystick, 8);
    private final JoystickButton buttonStart = new JoystickButton(joystick, 9);
    private final JoystickButton buttonBigLeft = new JoystickButton(joystick, 10);
    private final JoystickButton buttonBigRight = new JoystickButton(joystick, 11);


  private static joystickSubsystem INSTANCE = new joystickSubsystem();

  public static joystickSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (joystickSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new joystickSubsystem();
            }
        }
    }
    return INSTANCE;
}



public Joystick getJoystick(){
    return joystick;
  }

  public JoystickButton getJoystickButtonX(){
    return buttonX;
  }

  public JoystickButton getJoystickButtonY(){
    return buttonY;
  }

  public JoystickButton getJoystickButtonA(){
    return buttonA;
  }

  public JoystickButton getJoystickButtonB(){
    return buttonB;
  }

  public JoystickButton getJoystickButtonStart(){
    return buttonStart;
  }

  public JoystickButton getJoystickButtonBack(){
    return buttonBack;
  }

  public JoystickButton getJoystickButtonLeft(){
    return buttonLeft;
  }

  public JoystickButton getJoystickButtonRight(){
    return buttonRight;
  }

  public JoystickButton getJoystickButtonTopLeft(){
    return buttonTopLeft;
  }

  public JoystickButton getJoystickButtonTopRight(){
    return buttonTopRight;
  }

  public JoystickButton getJoystickButtonBigLeft(){
    return buttonBigLeft;
  }

  public JoystickButton getJoystickButtonBigRight(){
    return buttonBigRight;
  }
    
}
