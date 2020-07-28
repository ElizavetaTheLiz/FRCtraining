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
public final class Constants 
{
    public static int ElevEncoderPpr  = 2048;
    public static int ShootEncoderPpr = 2048;
    public static int leftEncoderPpr  = 2048;
    public static int rightEncoderPpr = 2048;

    public static double wheelRadius;

    public static double shooterKP;
    public static double shooterKI;
    public static double shooterKD;
    public static double elevKP;
    public static double kP;
    public static double kI;
    public static double kD;

    public static double driveTargetRPS = 0.7;

    public static double elevatorTopPosition  = 167;
    public static double elevatorDownPosition = 48.5;
    //the raising of the elevator(and intake it has) for each revolution of the elevator's encoder in centimeters
    public static double elevatorRaising;
    public static double leftDistancePerPulse  = 2 * Math.PI * wheelRadius / leftEncoderPpr;
    public static double rightDistancePerPulse = 2 * Math.PI * wheelRadius / rightEncoderPpr;

    public static int JoystickPort1 = 0;
    public static int JoystickPort2 = 1;

    public static int elevDown_button   = 1;
    public static int elevUp_button     = 3;
    public static int int_hop_button    = 0;
    public static int shooter_button    = 2;
    public static int elevReset_button  = 8;
    public static int driveReset_button = 9;

    public static int Axis1_1 = 1;
    public static int Axis1_2 = 3;

    public static int motor1       = 0;
    public static int motor2       = 1;
    public static int motor3       = 2;
    public static int motor4       = 3;
    public static int elevMotor    = 4;
    public static int elevMotor2   = 5;
    public static int intakeMotor  = 6;
    public static int hopperMotor  = 7;
    public static int shooterMotor = 8;

    public static int leftEncoderPort   = 0;
    public static int leftEncoderPort2  = 1;
    public static int rightEncoderPort  = 2;
    public static int rightEncoderPort2 = 3;
    public static int elevEncoderPort   = 4;
    public static int elevEncoderPort2  = 5;
    public static int shootEncoderPort  = 6;
    public static int shootEncoderPort2 = 7;

    public static double m_setpoint = 4.4;

}