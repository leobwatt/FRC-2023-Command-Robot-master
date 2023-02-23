// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.GenericHID;

//Commands
import frc.robot.commands.DriveWithController;
import frc.robot.commands.DriveTimed;
import frc.robot.commands.IntakeCone;
import frc.robot.commands.IntakeCube;
import frc.robot.commands.ReleaseCone;
import frc.robot.commands.ReleaseCube;
import frc.robot.commands.ArmExtend;
import frc.robot.commands.ArmTilt;
import frc.robot.commands.ArmTiltHold;

//Controller
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//Subsystems
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ArmSubsystem;

//Other
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  //Drivetrain
  private final DriveTrain driveTrain;
  private final DriveWithController driveWithController;
  private final DriveTimed driveTimed;

  //Intake
  private final IntakeSubsystem intake;
  private final IntakeCone intakeCone;
  private final IntakeCube intakeCube;
  private final ReleaseCone releaseCone;
  private final ReleaseCube releaseCube;

  //Arm
  private final ArmSubsystem arm;
  private final ArmExtend armExtend;
  private final ArmTilt armTilt;
  private final ArmTiltHold armTiltHold;

  //Other
  public static Timer timer;
  public static XboxController controller;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //Drivetrain
    driveTrain = new DriveTrain();
    driveWithController = new DriveWithController(driveTrain);
    driveTimed = new DriveTimed(driveTrain);
    driveWithController.addRequirements(driveTrain);
    driveTimed.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithController);

    //Intake
    intake = new IntakeSubsystem();
    intakeCone = new IntakeCone(intake);
    intakeCube = new IntakeCube(intake);
    releaseCone = new ReleaseCone(intake);
    releaseCube = new ReleaseCube(intake);
    intakeCone.addRequirements(intake);
    intakeCube.addRequirements(intake);
    releaseCone.addRequirements(intake);
    releaseCube.addRequirements(intake);

    //Arm
    arm = new ArmSubsystem();
    armExtend = new ArmExtend(arm);
    armTilt = new ArmTilt(arm);
    armTiltHold = new ArmTiltHold(arm);
    armExtend.addRequirements(arm);
    armTilt.addRequirements(arm);
    armTiltHold.addRequirements(arm);

    //Other
    timer = new Timer();
    controller = new XboxController(Constants.CONTROLLER_NUMBER);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureButtonBindings() {

    JoystickButton aButton = new JoystickButton(controller, XboxController.Button.kA.value);
    JoystickButton bButton = new JoystickButton(controller, XboxController.Button.kB.value);
    JoystickButton xButton = new JoystickButton(controller, XboxController.Button.kX.value);
    // JoystickButton yButton = new JoystickButton(controller, XboxController.Button.kY.value);
    JoystickButton leftBumper = new JoystickButton(controller, XboxController.Button.kLeftBumper.value);
    JoystickButton rightBumper = new JoystickButton(controller, XboxController.Button.kRightBumper.value);
    JoystickButton rightTrigger = new JoystickButton(controller, XboxController.Axis.kRightTrigger.value);
    JoystickButton leftTrigger = new JoystickButton(controller, XboxController.Axis.kLeftTrigger.value);

    rightTrigger.whileTrue(intakeCone);
    leftTrigger.whileTrue(intakeCube);
    leftBumper.whileTrue(releaseCone);
    rightBumper.whileTrue(releaseCube);

    aButton.whileTrue(armExtend);
    bButton.whileTrue(armTilt);

    xButton.whileTrue(armTiltHold);
  }
}
