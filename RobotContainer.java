/*
* This file contains the RobotContainer class
* It is where the bulk of the robot should be declared.
* The RobotContainer is used to define subsystems, commands, and button mappings.
*/

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.JoystickDriveC;
import frc.robot.subsystems.DriveTrainSS;
import frc.robot.subsystems.ShooterSS;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// Import other subsystems and commands as needed

public class RobotContainer {
  private final DriveTrainSS driveTrainSS = new DriveTrainSS();
  private final ShooterSS shooterSS = new ShooterSS();
  // Instantiate subsystems

  public static CommandXboxController controller = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  // Instantiate the controller

  public RobotContainer() {
    configureBindings();
  }
  // Constructor to set up button bindings

  private void configureBindings() {
    driveTrainSS.setDefaultCommand(new JoystickDriveC(driveTrainSS));
    // Set default command for driving
    controller.x().whileTrue(driveTrainSS.fasterTurning());
    // Run the fasterTurning command only while X is held
    controller.rightTrigger().whileTrue(shooterSS.shootNormal());
    // Run the shootNormal command only while right trigger is held
    controller.b().whileTrue(shooterSS.load());
    // Run the load command only while B is held
    controller.y().whileTrue(shooterSS.unload());
    // Run the unload command only while Y is held
  }

  public Command getAutonomousCommand() {
    return Autos.simpleAuto(driveTrainSS);
  }
  // Returns the command to run in autonomous
  // I don't know how this part works yet
}
