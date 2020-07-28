package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;


public class ShooterCommand extends PIDCommand {

    private static double m_motorOutput;

    public ShooterCommand(double targetRPM, ShooterSubsystem shooter) {
        super(
                // The controller that the command will use
                new PIDController(Constants.shooterKP, Constants.shooterKI, Constants.shooterKD),
                // This should return the measurement
                shooter::getRPM,
                // This should return the setpoint (can also be a constant)
                targetRPM,
                // This uses the output
                output -> {
                    // Use the output here
                    m_motorOutput = output;
                    shooter.runShooter(m_motorOutput);
                });
        // Use addRequirements() here to declare subsystem dependencies.
        // Configure additional PID options by calling `getController` here.
        getController().setTolerance(100);
        addRequirements(shooter);
    }


    @Override
    public void initialize() {
        super.initialize();
        m_motorOutput = 0;
    }

    @Override
    public void execute() {
        super.execute();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
            return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}