// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.auto.AprilTagAuto;
import frc.robot.subsystems.Extaker;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.drivebase.*;
import frc.robot.commands.extake.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static final Drivebase drivebase = new Drivebase();
  public static final Extaker extaker = new Extaker();

  private static XboxController driveStick = new XboxController(0);

  // The robot's subsystems and commands are defined here...  
  private final SequentialCommandGroup aprilTagAutoGroup = 
    new SequentialCommandGroup(
      new AprilTagAuto(drivebase, extaker), 
      new DumpTubes(extaker)
    );

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drivebase.setDefaultCommand(
      new Drive(
        drivebase,
        () -> driveStick.getLeftY(),
        () -> driveStick.getRightX()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(driveStick, Button.kLeftBumper.value).whenPressed(new ShiftDown(drivebase), true);
    new JoystickButton(driveStick, Button.kRightBumper.value).whenPressed(new ShiftUp(drivebase), true);
    new JoystickButton(driveStick, Button.kA.value).whenPressed(new DumpTubes(extaker), true);
    new JoystickButton(driveStick, Button.kB.value).whenPressed(new CloseTowerExtake(extaker), true);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return aprilTagAutoGroup;
  }
}