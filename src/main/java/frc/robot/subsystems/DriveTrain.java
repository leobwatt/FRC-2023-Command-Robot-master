// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftBack;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX rightBack;
  
  MecanumDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    leftFront = new WPI_TalonSRX(Constants.LEFT_FRONT);
    leftBack = new WPI_TalonSRX(Constants.LEFT_BACK);
    rightFront = new WPI_TalonSRX(Constants.RIGHT_FRONT);
    rightBack = new WPI_TalonSRX(Constants.RIGHT_BACK);

    drive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);

    rightFront.setInverted(true);
    rightBack.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithController (XboxController controller) {

    drive.driveCartesian(-controller.getLeftY()*Constants.DRIVE_SPEED, controller.getLeftX()*Constants.DRIVE_SPEED, controller.getRightX()*Constants.DRIVE_ROTATION_SPEED);
  }
 
  public void driveBackward () {
    drive.driveCartesian(-0.5, -0.5, 0);
  }
  public void stop() {

  drive.stopMotor();

  }

}
