// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.extake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants.ExtakeConstants;
import frc.robot.subsystems.Extaker;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DumpTubes extends InstantCommand {
  private final Extaker extake;

  public DumpTubes(Extaker extake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.extake = extake;

    addRequirements(this.extake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      extake.setExtakePiston(true);
  }
}
