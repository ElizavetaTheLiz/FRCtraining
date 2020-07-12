/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.RedlineCommand;
import frc.robot.subsystems.*;




public class RobotContainer {
    private final AutoCommand autonomousCommand = new AutoCommand();
    private final RedlineCommand redlineCommand = new RedlineCommand();



    public RobotContainer(){
        configureButtonBindings();
    }

    private void configureButtonBindings(){
        JoystickSubsystem.button1.whileActiveContinuous(redlineCommand);
    }

    public Command getAutonomousCommand(){
        return autonomousCommand;
    }
}
