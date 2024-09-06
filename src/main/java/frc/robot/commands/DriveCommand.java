package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {

    DriveSubsystem subsystem;
    DoubleSupplier drivePower, turnPower;


    public DriveCommand(DriveSubsystem subsystem, DoubleSupplier drivePower, DoubleSupplier turnPower) {
        this.subsystem = subsystem;
        this.addRequirements(this.subsystem);
        this.drivePower = drivePower;
        this.turnPower = turnPower;//maybe it will cease the screams
    }
    @Override
    public void execute() {
        //:-1 because y goes kinda backwards
        subsystem.Drive(-1*drivePower.getAsDouble(), turnPower.getAsDouble());
    }
}
