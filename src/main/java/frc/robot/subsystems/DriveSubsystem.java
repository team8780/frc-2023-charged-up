// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class DriveSubsystem extends SubsystemBase {

  private final CANSparkMax m_frontLeftSpark = new CANSparkMax(OperatorConstants.kFrontLeftID, MotorType.kBrushed);
  private final CANSparkMax m_frontRightSpark = new CANSparkMax(OperatorConstants.kFrontRightID, MotorType.kBrushed);
  private final CANSparkMax m_rearLeftSpark = new CANSparkMax(OperatorConstants.kRearLeftID, MotorType.kBrushed);
  private final CANSparkMax m_rearRightSpark = new CANSparkMax(OperatorConstants.kRearRightID, MotorType.kBrushed);

  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_frontLeftSpark, m_rearLeftSpark);
  private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_frontRightSpark, m_rearRightSpark);

  private final DifferentialDrive drivetrain = new DifferentialDrive(m_leftDrive, m_rightDrive);

  public DriveSubsystem() {
    m_rightDrive.setInverted(true);
  }

  public void arcadeDrive(double xDrive, double zDrive){
    drivetrain.arcadeDrive(xDrive, zDrive);
  }

  public boolean enableDrive(){
    return RobotState.isTeleop();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
