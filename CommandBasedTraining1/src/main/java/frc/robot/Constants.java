/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants{

    public static final class RoboRIO_PWM_Channels{
        public static int Motorchannel1 = 0;
        public static int Motorchannel2 = 1;
        public static int Motorchannel3 = 2;
        public static int Motorchannel4 = 3;
        public static int Motorchannel5 = 4;
    }

    public static final class RoboRIO_PCM_Port{
        public static int port = 1;
    }


    public static final class Joystick{
        public static int JoystickPort = 1;
        public static int Button1 = 1;
        public static int Button2 = 2;
        public static int Axis1 = 1;
        public static int Axis2 = 3;
    }
}