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

    public final class roboRIOPWMPorts{
        public static final int driveLeft1     = 0;
        public static final int driveLeft2     = 1;
        public static final int driveRight1    = 2;
        public static final int driveRight2    = 3;
        public static final int hangMotor      = 4;
        public static final int intakeMotor1   = 5;
        public static final int intakeMotor2   = 6;
        public static final int intakeMotor3   = 7;
        public static final int elevatorMotor1 = 8;
        public static final int elevatorMotor2 = 9;
    }

    public final class roboRIOAnalogPorts{
        public static final int driveGyro      = 0;
    }

    public final class roboRIODigitalPorts{
        public static final int driveEncoder1     = 0;
        public static final int driveEncoder2     = 1;
        public static final int driveEncoder3     = 2;
        public static final int driveEncoder4     = 3;
        public static final int elevatorEncoder1  = 4;
        public static final int elevatorEncoder2  = 5;
        public static final int hangEncoder1      = 6;
        public static final int hangEncoder2      = 7;
        public static final int intakeEncoder1    = 8;
        public static final int intakeEncoder2    = 9;
    }

    public final class robotFeatures{
        public static final double wheelRadius                = 10.5;
        public static final int encoderPPR                    = 1000;
        public static final double elevatorEncoderMovePerTour   = 10;
        public static final double wheelBase                    = 55;
        public static final double wheelTrack                   = 45;


        //the lowermost position of Intake in centimeters
        public static final double minPosElev     = 15.0;
        //the height of intake's "take the ball from the floor" position in centimeters
        public static final double floorPosElev   = 16.0;
        //the height of intake's "put the ball into the portal" position in centimeters
        public static final double portalPosElev  = 20.0;
        //the height of intake's "leave the ball into the switch" position in centimeters
        public static final double switchPosElev = 100.0;
        //the height of intake's "leave the ball into the scale" position in centimeters
        public static final double scalePosElev  = 190.0;
        //the distance between elevators lowermost position and elevators hang position in centimeters
        public static final double hangPosElev =  213.36;
        //the height of intake's "go as high as you can go" position in centimeters
        public static final double maxPosElev    = 265.0;        
    }

    public final class joystick{
        public static final int joystickPort = 0;
        public static final int rawAxis1     = 1;
        public static final int rawAxis2     = 3;
        
    }

    public final class iO{
        public static final double elevatorSpeed =  .7;
        public static final double hangSpeed =      .8;
        public static final double intakeSpeed =    .5;
        public static final double intakeDegrees = 180;
    }

    public final class characterization{
        
        public static final double kS = 1.478;
        public static final double kV =  1.89;
        public static final double kA = 0.243;
        public static final double kP = 0.341;
        public static final double kI =     0;
        public static final double kD =     0;
    }

    public final class autonomous{
        
        public static final double maxVelocityMetersPerSecond      = 3;
        public static final double maxAccelarationMetersPerSecond  = 3;
        public static final double Pose2d_Axis_X                  = 50;
        public static final double Pose2d_Axis_Y                  = 50;
    }
}
