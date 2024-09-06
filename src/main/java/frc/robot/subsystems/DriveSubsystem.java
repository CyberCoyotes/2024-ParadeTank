package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


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
     public  WPI_TalonSRX rMasterMotor0 = new WPI_TalonSRX(0);
     
     private WPI_TalonSRX rSlaveMmotor1= new WPI_TalonSRX(1); //private as we won't need to access the slaves
     public WPI_TalonSRX lMasterMotor3= new WPI_TalonSRX(3);
     private WPI_TalonSRX lSlaveMotor5= new WPI_TalonSRX(5); //private as we won't need to access the slaves
     WPI_TalonSRX[] motors = {rMasterMotor0, rSlaveMmotor1, lMasterMotor3, rSlaveMmotor1};//ease of access
     
    //need to learn how to make motorgroupings with talonfx
    //#endregion
    public DriveSubsystem() {
        rMasterMotor0.setInverted(true);
        rSlaveMmotor1.setInverted(true);
        for (WPI_TalonSRX talonSRX : motors) {
            talonSRX.configFactoryDefault();
        }
        //:set the slave motors to mimic the accessible ones, mimicking a motor controller group
            rSlaveMmotor1.set(TalonSRXControlMode.Follower, rMasterMotor0.getDeviceID());
             lSlaveMotor5.set(TalonSRXControlMode.Follower, lMasterMotor3.getDeviceID());
             
            _drive = new DifferentialDrive(lMasterMotor3, rMasterMotor0);
        
    }
    public void Drive(double drivePower, double turnPower )
    {
       
        _drive.arcadeDrive(drivePower, turnPower);
    }
}
