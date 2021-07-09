package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.climberSubsystem;

public class climberDown extends CommandBase{
    
    private final climberSubsystem climber = climberSubsystem.getInstance();

    private boolean position = false;

    public climberDown(climberSubsystem climber) {
        addRequirements(climber);
    }

    @Override
    public void initialize() {
  
    }

    @Override
    public void execute() {
        if(climber.getEncoderDistance() < Constants.climber.climberDownPosition){
            climber.openClimberMotors(0.7);
        }
        else if(climber.getEncoderDistance() > Constants.climber.climberDownPosition){
            climber.openClimberMotors(-0.7);
        }
        else{
            position = true;
        }
    }


    @Override
    public void end(boolean interrupted) {
        climber.stopClimberMotors();
    }

    @Override
    public boolean isFinished() {
      return position;
    }


}
