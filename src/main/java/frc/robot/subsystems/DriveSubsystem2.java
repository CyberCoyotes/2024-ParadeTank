/* 
Subsystem for the drive train. 
This is the second version of the drive train subsystem. 
It should setup a right side and left side with two motors each.
It is using SIM motors and Talon SRX controllers. 
The right side Leader motor and left side follow motor should not inverted.
The left side Leader motor and right side follow motor should be inverted.
The left thumbstick will control the forward and backward movement of the robot.
The right thumbstick will control the rotation of the robot.
*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem2 extends SubsystemBase {
    private final DifferentialDrive drive;
    private final WPI_TalonSRX rightLeaderMotor;
    private final WPI_TalonSRX rightFollowerMotor;
    private final WPI_TalonSRX leftLeaderMotor;
    private final WPI_TalonSRX leftFollowerMotor;

    public DriveSubsystem2() {
        rightLeaderMotor = new WPI_TalonSRX(Constants.RIGHT_LEADER_ID);
        rightFollowerMotor = new WPI_TalonSRX(Constants.RIGHT_FOLLOWER_ID);
        leftLeaderMotor = new WPI_TalonSRX(Constants.LEFT_LEADER_ID);
        leftFollowerMotor = new WPI_TalonSRX(Constants.LEFT_FOLLOWER_ID);

        rightLeaderMotor.setInverted(false);
        rightFollowerMotor.setInverted(true);
        leftLeaderMotor.setInverted(true);
        leftFollowerMotor.setInverted(false);

        rightFollowerMotor.follow(rightLeaderMotor);
        leftFollowerMotor.follow(leftLeaderMotor);

        drive = new DifferentialDrive(leftLeaderMotor, rightLeaderMotor);
    }

    public void drive(double forward, double rotation) {
        drive.arcadeDrive(forward, rotation);
    }
}