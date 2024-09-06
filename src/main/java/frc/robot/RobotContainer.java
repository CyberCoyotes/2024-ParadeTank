// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;


public class RobotContainer {
  private XboxController d_Controller = new XboxController(Constants.driver_controller_port);
  

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();


 
  public RobotContainer() {
    
  
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, d_Controller::getLeftY, d_Controller::getRightX)
    );
  }

  public Command getAutonomousCommand() {
    return new WaitCommand(1);
  }
}
