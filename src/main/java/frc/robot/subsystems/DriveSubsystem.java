package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    private final DifferentialDrive drive;
    private final WPI_TalonSRX rightLeaderDrive;
    // private final WPI_TalonSRX rightFollowerDrive;
    private final WPI_TalonSRX leftLeaderDrive;
    // private final WPI_TalonSRX leftFollowerDrive;
    private final WPI_TalonSRX[] motors;

    public DriveSubsystem() {
        rightLeaderDrive = new WPI_TalonSRX(Constants.RIGHT_LEADER_ID);
        // rightFollowerDrive = new WPI_TalonSRX(Constants.RIGHT_FOLLOWER_ID);
        leftLeaderDrive = new WPI_TalonSRX(Constants.LEFT_LEADER_ID);
        // leftFollowerDrive = new WPI_TalonSRX(Constants.LEFT_FOLLOWER_ID);

        motors = new WPI_TalonSRX[]{
            rightLeaderDrive, 
            // rightFollowerDrive,
            leftLeaderDrive
            //,leftFollowerDrive
        };

        configureMotors();
        drive = new DifferentialDrive(rightLeaderDrive, leftLeaderDrive);
    }

    private void configureMotors() {
        rightLeaderDrive.setInverted(true);
        // rightFollowerDrive.setInverted(true);
        leftLeaderDrive.setInverted(false);
        // leftFollowerDrive.setInverted(false);

        for (WPI_TalonSRX motor : motors) {
            motor.configFactoryDefault();
        }

        // rightFollowerDrive.set(TalonSRXControlMode.Follower, rightLeaderDrive.getDeviceID());
        // leftFollowerDrive.set(TalonSRXControlMode.Follower, leftLeaderDrive.getDeviceID());
    }

    public void drive(double drivePower, double turnPower) {
        drive.arcadeDrive(drivePower, turnPower);
    }
}