package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SolenoidSubsystem;

public class SolenoidCommand extends CommandBase {
    public SolenoidSubsystem m_solenoid = SolenoidSubsystem.getInstance();

    public SolenoidCommand() {
        addRequirements(this.m_solenoid);
    }


    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_solenoid.solenoidCalistirma(true);
    }


    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public  void end(final boolean interrupted) {
        m_solenoid.solenoidCalistirma(false);
    }

}

