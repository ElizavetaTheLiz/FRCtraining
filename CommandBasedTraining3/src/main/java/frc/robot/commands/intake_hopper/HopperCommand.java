package frc.robot.commands.intake_hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;


public class HopperCommand extends CommandBase
{

    private final HopperSubsystem hopperSubsystem = HopperSubsystem.getInstance();


    public HopperCommand() {
        addRequirements(this.hopperSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        hopperSubsystem.hopperPos(true);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        hopperSubsystem.hopperPos(false);
    }
}
