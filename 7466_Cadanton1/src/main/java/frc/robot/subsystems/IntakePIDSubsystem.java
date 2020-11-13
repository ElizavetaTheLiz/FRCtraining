package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;


public class IntakePIDSubsystem extends PIDSubsystem {

    public IntakePIDSubsystem(PIDController controller) {
        super(controller);
    }

    @Override
    protected double getMeasurement() {
        return 0;
    }

    @Override
    protected void useOutput(double output, double setpoint) {

    }

    @Override
    public void setSetpoint(double setpoint) {
        super.setSetpoint(setpoint);
    }
}
