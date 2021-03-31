// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


    public static final class PWMPorts{
        public static final int motor1  = 0;
        public static final int motor2  = 1;
        public static final int motor3  = 2;
        public static final int motor4  = 3;
        public static final int redline = 4;

    }

    public static final class AnalogPorts{
        public static final int encoder1 = 0;
        public static final int encoder2 = 1;
        public static final int sonic1   = 2;
        public static final int sonic2   = 3;
    }

    public static final class RobotFeatures{
        public static final int wheelRadius = 3;
        public static final int encoderPulse = 120;
    }

    public static final class IO{
        public static final int joystickPort = 0;
        public static final int buttonNumber = 0;
    }

    public static final class Control{
        public static final double RedlineSpeed = 0.7;
        public static final int AxisLeft  = 1;
        public static final int AxisRight = 3;
        public static final double sonicAutoDistance   = 50;
        public static final double sonicDriveDistance  = 5;
        public static final double encoderAutoDistance = 200;
        public static final double driveAutoSpeed      = 0.7;
    }


    
}
