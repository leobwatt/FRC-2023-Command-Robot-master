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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
    //CAN/PWM for wiring
    public static final int LEFT_FRONT = 3;
    public static final int LEFT_BACK = 4;
    public static final int RIGHT_FRONT = 1;
    public static final int RIGHT_BACK = 2;
    public static final int INTAKE = 5;
    public static final int ARM_EXTEND = 6;
    public static final int ARM_TILT = 0;

    //speeds
    public static final double DRIVE_SPEED = 0.6;
    public static final double DRIVE_ROTATION_SPEED = 0.4;
    public static final double AUTONOMOUS_SPEED = 0.4;
    public static final double INTAKE_SPEED = 0.6;
    public static final double ARM_SPEED = 0.5;

    //controller
    public static final int CONTROLLER_NUMBER = 0;
    public static final int RIGHT_TRIGGER = 3;
    public static final int LEFT_TRIGGER = 2;
    public static final int A_BUTTON = 4;
    public static final int B_BUTTON = 5;

    //times
    public static final double DRIVE_TIME = 4;
    public static final double AUTO_RELEASE_TIME = 4;

    }
