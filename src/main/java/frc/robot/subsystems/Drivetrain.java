package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.CanIdConstants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase{
    private CANSparkMax rightLeader = new CANSparkMax(CanIdConstants.RIGHT_LEADER_ID, MotorType.kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax(CanIdConstants.RIGHT_FOLLOWER_ID, MotorType.kBrushless);
    private CANSparkMax leftLeader = new CANSparkMax(CanIdConstants.LEFT_LEADER_ID, MotorType.kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax(CanIdConstants.LEFT_FOLLOWER_ID, MotorType.kBrushless);

    private final DifferentialDrive differentialDrive = new DifferentialDrive(leftLeader, rightLeader);

    public Drivetrain() {
        rightLeader.setSmartCurrentLimit(40);
        rightFollower.setSmartCurrentLimit(40);
        leftLeader.setSmartCurrentLimit(40);
        leftFollower.setSmartCurrentLimit(40);

    rightLeader.setIdleMode(IdleMode.kBrake);   
        rightFollower.setIdleMode(IdleMode.kBrake);
        leftLeader.setIdleMode(IdleMode.kBrake);
        SmartDashboard.putNumber("RPM", leftLeader.getBusVoltage());
        SmartDashboard.putNumber("RPM", rightLeader.getBusVoltage()); 
    }
}
