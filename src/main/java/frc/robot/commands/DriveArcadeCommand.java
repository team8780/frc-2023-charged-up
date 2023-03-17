// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.OperatorConstants;

public class DriveArcadeCommand extends CommandBase {

  private final DriveSubsystem m_driveSubsystem;

  public DriveArcadeCommand(DriveSubsystem subsystem) {
    m_driveSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xDrive = OperatorConstants.kDriveSpeed * RobotContainer.m_driverController.getLeftY();
    double zDrive = OperatorConstants.kDriveSpeed * RobotContainer.m_driverController.getRightX();
    m_driveSubsystem.arcadeDrive(xDrive, zDrive);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
