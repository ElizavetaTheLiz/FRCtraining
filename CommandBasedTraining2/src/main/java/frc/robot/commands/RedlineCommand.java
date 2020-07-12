package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RedlineSubsystem;

public class RedlineCommand extends CommandBase{

    private final RedlineSubsystem redlineSubsystem = RedlineSubsystem.getInstance();

    public RedlineCommand(){
        addRequirements(this.redlineSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        redlineSubsystem.redlineAc();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        redlineSubsystem.redlineKapat();
    }
}
