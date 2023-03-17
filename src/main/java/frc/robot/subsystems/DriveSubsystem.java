// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private CANSparkMax m_frontLeftDrive = new CANSparkMax(0, MotorType.kBrushed);
    private CANSparkMax m_frontRightDrive = new CANSparkMax(0, MotorType.kBrushed);
    private CANSparkMax m_rearLeftDrive = new CANSparkMax(0, MotorType.kBrushed);
    private CANSparkMax m_rearRightDrive = new CANSparkMax(0, MotorType.kBrushed); 

    private MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_frontLeftDrive, m_rearLeftDrive);
    private MotorController m_rightDrive = new MotorControllerGroup(m_frontRightDrive, m_rearRightDrive);
    public DifferentialDrive drivetrain = new DifferentialDrive(m_leftDrive, m_rightDrive);

  public DriveSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean enableDrive() {
    return RobotState.isTeleop();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
