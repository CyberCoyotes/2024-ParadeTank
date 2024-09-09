package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command; // Command has replaced CommandBase
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {

    private final DriveSubsystem subsystem;
    private final DoubleSupplier drivePower;
    private final DoubleSupplier turnPower;

    public DriveCommand(DriveSubsystem subsystem, DoubleSupplier drivePower, DoubleSupplier turnPower) {
        this.subsystem = subsystem;
        this.drivePower = drivePower;
        this.turnPower = turnPower;
        addRequirements(this.subsystem);
    }

    @Override
    public void execute() {
        subsystem.drive(-1 * drivePower.getAsDouble(), turnPower.getAsDouble());
    }
}