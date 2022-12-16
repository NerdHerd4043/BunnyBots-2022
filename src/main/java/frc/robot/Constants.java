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
    public static final class DriveConstants{
        public static final int frontLeftMotorID = 10;
        public static final int frontRightMotorID = 8;
        public static final int backLeftMotorID = 6;
        public static final int backRightMotorID = 3;

        public static final int currentLimit = 40;

        public static final int shifterID = 0;

        public static final class Gears{
            public static final boolean highGear = true;
            public static final boolean lowGear = false;
        }
    }
    
    public static final class ExtakeConstants{
        public static final int dumperPistonID = 1;
    }

    public static final class DashboardStrings{
        public static final String gearMode = "Gear Mode";
    }
}