// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ExtakeConstants;

public class Deploy extends SubsystemBase {
  /** Creates a new Deploy. */

  private Solenoid extakePiston = new Solenoid(PneumaticsModuleType.CTREPCM, ExtakeConstants.dumperPistonID);

  public Deploy() {}

  public void setExtakePiston(boolean b){
    extakePiston.set(b);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
