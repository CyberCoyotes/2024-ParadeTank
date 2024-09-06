package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

//? Use WPI_talonSRX rather than talonSRX?

public class DriveSubsystem extends SubsystemBase{
    DifferentialDrive _drive;
    //#region motors
  
 
     /*Motor notes
       3 2 ^
     //4 2 | //!pointless
     //5 0 |
     // 2 and 4 are there for dust collection, don't bother
     //Motors on Wille are TalonSRXs
     //  All of the motor controllers are properly mapped via IDs  */
         
     //motor 2 disconnected
      //motor 4 disconnected
     public  WPI_TalonSRX right_main_motor = new WPI_TalonSRX(Constants.right_main_motor_ID);
     private WPI_TalonSRX right_secondary_motor= new WPI_TalonSRX(Constants.right_secondary_motor_ID); //private as we won't need to access the slaves
     public WPI_TalonSRX left_main_motor= new WPI_TalonSRX(Constants.left_main_motor_ID);
     private WPI_TalonSRX left_secondary_motor= new WPI_TalonSRX(Constants.left_secondary_motor_ID); //private as we won't need to access the slaves

     WPI_TalonSRX[] motors = {right_main_motor, right_secondary_motor, left_main_motor, left_secondary_motor};//ease of access
     
    //need to learn how to make motorgroupings with talonfx
    //#endregion
    public DriveSubsystem() {
        right_main_motor.setInverted(true);
        right_secondary_motor.setInverted(true);
        for (WPI_TalonSRX talonSRX : motors) {
            talonSRX.configFactoryDefault();
        }
        //:set the slave motors to mimic the accessible ones, mimicking a motor controller group
        right_secondary_motor.set(TalonSRXControlMode.Follower, right_main_motor.getDeviceID());
        left_secondary_motor.set(TalonSRXControlMode.Follower, left_main_motor.getDeviceID());
             
            _drive = new DifferentialDrive(left_main_motor, right_main_motor);
        
    }
    public void Drive(double drivePower, double turnPower )
    {
       
        _drive.arcadeDrive(drivePower, turnPower);
    }
}
