/*
* This file is contains the autonomous commands.
* There should be multiple commands here for different autonomous routines.
*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.DriveTrainSS;
// Import other subsystems as needed

public final class Autos {
  public static Command simpleAuto(DriveTrainSS driveTrainSS) {
    return Commands.sequence(
        Commands.runOnce(() -> driveTrainSS.setMotorSpeeds(0.5, 0.5)),
        Commands.waitSeconds(2),
        Commands.runOnce(() -> driveTrainSS.setMotorSpeeds(0.0, 0.0))
    );
  }
  // Move forward for 2 seconds

  /* New command(s) go here as methods: */
}