package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.Timer;

public class ArmSubsystem extends SubsystemBase {

  Spark armExtend;
  Spark armTilt;
  RobotContainer robotContainer;

  Timer timer;

  public ArmSubsystem() {

  }

  public void init() {
    armExtend = new Spark(Constants.ARM_EXTEND);
    armTilt = new Spark(Constants.ARM_TILT);

    timer = new Timer();

    timer.reset();
    timer.start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void armExtend(XboxController controller) {
    armExtend.set(controller.getRawAxis(Constants.A_BUTTON) * Constants.ARM_SPEED);
  }

  public void armTilt(XboxController controller) {
    armTilt.set(controller.getRawAxis(Constants.B_BUTTON) * Constants.ARM_SPEED);
  }

  public void armTiltHold(Timer timer) {
    armTilt.set(0.1);

    if (timer.get() < 1) {
      armTilt.set(-0.1);
    }
  }

  public void stop() {
    armExtend.set(0.0);
    armTilt.set(0.0);
  }
}
