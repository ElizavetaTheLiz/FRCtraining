// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {

    private final PWMVictorSPX motor1 = new PWMVictorSPX(Constants.roboRIOPWMPorts.elevatorMotor1);
    private final PWMVictorSPX motor2 = new PWMVictorSPX(Constants.roboRIOPWMPorts.elevatorMotor2);

    private final SpeedControllerGroup upDownMotors = new SpeedControllerGroup(motor1, motor2);

    private final Encoder encoder = new Encoder(Constants.roboRIODigitalPorts.elevatorEncoder1, Constants.roboRIODigitalPorts.elevatorEncoder2);


    private static ElevatorSubsystem INSTANCE = new ElevatorSubsystem();

    public static ElevatorSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (ElevatorSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new ElevatorSubsystem();
              }
          }
      }
      return INSTANCE;
  }

  //ENCODER METHODS

      //Encoder Distance Methods
      public double getElevatorRaising(){
        encoder.setDistancePerPulse(Constants.robotFeatures.elevatorEncoderMovePerTour/Constants.robotFeatures.encoderPPR);
        return encoder.getDistance();

    }


      //Encoder Reset Method
    public void encoderReset(){
        encoder.reset();
    }

 
    //ELEVATOR METHODS
  
       //Elevator Upgrade Method
    public void elevatorUp(double elevator_speed){
        
        if(elevator_speed > 0){
            upDownMotors.set(elevator_speed);
            
        }
        else{
            upDownMotors.set(0.0);
        }    
    }
      
    
        //Elevator Lowering Method
    public void elevatorDown(double elevator_speed2){
        
        if(elevator_speed2 < 0){
            upDownMotors.set(elevator_speed2);
        }

        else{
            upDownMotors.set(0.0);
        }
    }
    
    
        //Elevator Stop Method
    public void elevatorStop(){
        upDownMotors.set(0.0);
    }

  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
