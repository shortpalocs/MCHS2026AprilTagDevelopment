/*
 * This file contains the Robot class.
 * It is the main entry point for the robot code.
 * It controls the flow of modes and initializes the RobotContainer.
 */

package frc.robot;

// Camera
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.apriltag.AprilTagDetection;
import edu.wpi.first.apriltag.AprilTagDetector;
import edu.wpi.first.apriltag.AprilTagPoseEstimator;

// WPILib
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*;

// Geometry
import edu.wpi.first.math.geometry.Transform3d;

// NetworkTables
import edu.wpi.first.networktables.NetworkTableInstance;

// OpenCV
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import frc.robot.RobotContainer;

public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private final RobotContainer m_robotContainer;

  public Robot() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotInit() {
    // Start vision thread
    
  }
  @Override
  public void robotPeriodic() {
    // Runs the CommandScheduler, which polls buttons and runs commands
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      CommandScheduler.getInstance().schedule(m_autonomousCommand);
    }
  }

  @Override
  public void teleopInit() {
    // Cancel autonomous command when teleop starts
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}