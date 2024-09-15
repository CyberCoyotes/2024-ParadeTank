/*
 * This command will drive the robot using the drive and turn power values from the joysticks.
 * The left thumbstick will control the forward and backward movement of the robot.
 * The right thumbstick will control the rotation of the robot. 
 */

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem2;

public class DriveCommand2 extends Command {

    private final DriveSubsystem2 subsystem;
    private final XboxController joystick;

    public DriveCommand2(DriveSubsystem2 subsystem, XboxController driveController) {
        this.subsystem = subsystem;
        this.joystick = driveController;
        addRequirements(this.subsystem);
    }

    @Override
    public void execute() {
        // Assuming the forward/backward movement is controlled by the Y-axis of the left thumbstick
        // Negative value had the robot moving backwards
        double drivePower = -joystick.getRawAxis(1); 

        // Assuming the rotation is controlled by the X-axis of the right thumbstick
        double turnPower = joystick.getRawAxis(4); 

        // Added for debugging purposes
        // System.out.println("Drive Power: " + drivePower + ", Turn Power: " + turnPower);

        subsystem.drive(drivePower, turnPower);

    }
}