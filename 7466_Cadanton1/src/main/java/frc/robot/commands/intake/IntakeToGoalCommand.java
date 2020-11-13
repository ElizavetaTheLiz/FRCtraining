package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeToGoalCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();

    private boolean position = false;


    public IntakeToGoalCommand(){
        addRequirements(this.intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intakeSubsystem.turnTheIntake(intakeSubsystem.getOutputSpeed());
        if(intakeSubsystem.getAngle() == Constants.RobotFeatures.intakeAngle){
            position = true;
        }
    }

    @Override
    public boolean isFinished() {
        return position;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
