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

    public static final class fixed{
        public static double kP = 0;
        public static double kI = 0;
        public static double kD = 0;

        public static double elevKP = 0;
        public static double elevKI = 0;
        public static double elevKD = 0;

        public static double intakeKP = 0.006;
        public static double intakeKI = 0;
        public static double intakeKD = 0;

        public static double kS = 0.268;
        public static double kV = 1.89;
        public static double kA = 0.243;

        public static double elevKS = 0.268;
        public static double elevKV = 1.89;
        public static double elevKA = 0.243;
        public static double elevKG = 0.268;

        public static double elevToleranceRPS;
        public static double elevSetpointRPS;
    }

    public static final class RoboRIO_PWM_Channels{
        public static int MasterMotor1 = 0;
        public static int MasterMotor2 = 1;
        public static int MasterMotor3 = 2;
        public static int MasterMotor4 = 3;

        public static int IntakeMotor1 = 4;
        public static int IntakeMotor2 = 5;
        public static int IntakeMotorTurning = 6;

        public static int ElevatorMotorLeft   = 7;
        public static int ElevatorMotorLeft2  = 8;
        public static int ElevatorMotorRight  = 9;
        public static int ElevatorMotorRight2 = 10;
    }

    public static final class RoboRIO_DIO_Channels{
        public static int leftEncoder    = 0;
        public static int leftEncoder2   = 1;
        public static int rightEncoder   = 2;
        public static int rightEncoder2  = 3;
        public static int elevEncoder    = 4;
        public static int elevEncoder2   = 5;
        public static int intakeEncoder  = 6;
        public static int intakeEncoder2 = 7;
    }

    public static final class RobotFeatures{
        public static int leftEncoderPpr   = 2048;
        public static int rightEncoderPpr  = 2048;
        public static int elevEncoderPpr   = 2048;
        public static int intakeEncoderPpr = 2048;

        //wheels radius in centimeters
        public static double wheelRadius = 5.08;
        //the distance between left and right wheels (i.e. wheelBase, trackWidth) in centimeters
        public static double trackWidth = 63.65;

        //the lowermost position of Intake in centimeters
        public static double minPosIntake = 15.;
        //the height of intake's "take the ball from the floor" position in centimeters
        public static double floorPosIntake = 16.;
        //the height of intake's "leave the ball into the switch" position in centimeters
        public static double switchPosIntake = 100.;
        //the height of intake's "leave the ball into the scale" position in centimeters
        public static double scalePosIntake = 190.;
        //the distance between elevators lowermost position and elevators hang position in centimeters
        public static double hangPosElev = 213.36;
        //the distance between elevators lowermost position and elevators climb position in centimeters
        public static double climbPosElev = 100.;
        //the height of intake's "go as high as you can go" position in centimeters
        public static double maxPosIntake = 265.;
        //the raising of the elevator(and intake it has) for each revolution of the elevator's encoder in centimeters
        public static double elevatorRaising;
        //the goal angle of intake after turning to the other side
        public static double intakeAngle = 150;

        public static double leftEncoderDistancePerPulse  = 2* Math.PI * wheelRadius /  leftEncoderPpr;
        public static double rightEncoderDistancePerPulse = 2* Math.PI * wheelRadius / rightEncoderPpr;
        public static double elevEncoderDistancePerPulse  = elevatorRaising / elevEncoderPpr;
    }
}