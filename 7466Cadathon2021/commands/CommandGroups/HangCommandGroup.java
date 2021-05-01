package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ElevatorCommands.ElevatorHang;
import frc.robot.commands.HangCommands.HangUpCommand;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.HangSubsystem;
/**
 * A complex auto command that rises the hang up and changes the position of the elevator at the same time.
 * For more information about command groups: https://docs.wpilib.org/en/stable/docs/software/commandbased/command-groups.html
 */
public class HangCommandGroup extends ParallelCommandGroup{
    
    public HangCommandGroup(HangSubsystem hang, ElevatorSubsystem elevator){
        addCommands(new HangUpCommand(hang), new ElevatorHang(elevator));
    }
}
