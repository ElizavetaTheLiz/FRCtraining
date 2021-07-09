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

    public final  class encoder{
        public static final double elevatorEncoderMovePerTour = 0;
        public static final int encoderPPR = 0; 
        public static final double climberEncoderMovePerTour = 0;

    }

    public final class robotFeatures {
        public static final double wheelRadius = 0;
        public static final int encoderPPR = 0; 
        public static final int wheelTrack = 0;

    }

    public final class iO { 
        public static final double intakeSpeed = 0;

    }

    public final class climber {
        public static final double habitatStep2 = 0;
        public static final double habitatStep3 = 0;
        public static final double climberDownPosition = 0;
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
