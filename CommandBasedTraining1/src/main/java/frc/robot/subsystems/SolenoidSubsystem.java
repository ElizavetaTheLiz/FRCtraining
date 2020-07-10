/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;



public class SolenoidSubsystem extends SubsystemBase {
    private final static Solenoid m_Solenoid = new Solenoid(0);


    private static SolenoidSubsystem INSTANCE;

    public static SolenoidSubsystem getInstance() {
        if (INSTANCE == null){
            synchronized (SolenoidSubsystem.class){
                if (INSTANCE == null){
                    INSTANCE = new SolenoidSubsystem();
                }
            }
        }
        return INSTANCE;
    }


    public SolenoidSubsystem()
    {
        
    }


    public void solenoidCalistirma(boolean durum){
    m_Solenoid.set(durum);
    }


    @Override
    public void periodic()
    {

    }
}
