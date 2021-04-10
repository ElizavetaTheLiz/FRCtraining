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

    public final class RoboRIOPWMPorts{
        public static final int driveLeft1   = 0;
        public static final int driveLeft2   = 1;
        public static final int driveLeft3   = 2;
        public static final int driveRight1  = 3;
        public static final int driveRight2  = 4;
        public static final int driveRight3  = 5;
        public static final int hangMotor    = 6;
        public static final int intakeMotor1 = 7;
        public static final int intakeMotor2 = 8;
        public static final int elevatorMotor1 = 9;
        public static final int elevatorMotor2 = 10;
    }

    public final class RoboRIOAnalogPorts{
        public static final int driveEncoder1  = 0;
        public static final int driveEncoder2  = 1;
        public static final int driveEncoder3  = 2;
        public static final int driveEncoder4  = 3;
        public static final int driveGyro      = 4;
        public static final int elevator_encoder  = 5;
        public static final int elevator_encoder2  = 6;
    }

    public final class RobotFeatures{
        public static final double wheelRadius = 0;
        public static final int encoderPPR = 0;
        public static final double elevatorEncoderMovePerTour  = 0;


//the lowermost position of Intake in centimeters
        public static final double minPosElev = 15.;
        //the height of intake's "take the ball from the floor" position in centimeters
        public static final double floorPosElev = 16.;
        //the height of intake's "put the ball into the portal" position in centimeters
        public static final double portalPosElev = 20.;
        //the height of intake's "leave the ball into the switch" position in centimeters
        public static final double switchPosElev = 100.;
        //the height of intake's "leave the ball into the scale" position in centimeters
        public static final double scalePosElev = 190.;
        //the distance between elevators lowermost position and elevators hang position in centimeters
        public static final double hangPosElev = 213.36;
        //the height of intake's "go as high as you can go" position in centimeters
        public static final double maxPosElev = 265.;
        
    }

    public final class IO{

        
    }

    public final class Characterization{
        
        public static final double kS = 1.478;
        public static final double kV = 1.89;
        public static final double kA = 0.243;
    }
}
