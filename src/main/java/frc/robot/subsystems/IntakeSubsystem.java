package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    Spark intake1;
    Spark intake2;
    RobotContainer robotContainer;

    public IntakeSubsystem() {

    }

    public void init() {
        intake1  = new Spark(Constants.INTAKE);
        intake2  = new Spark(Constants.INTAKE);
    }

    @Override
    public void periodic() {

    }

    public void IntakeCone(XboxController controller) {
        intake1.set(-controller.getRawAxis(Constants.RIGHT_TRIGGER)*Constants.INTAKE_SPEED); //negative
        intake2.set(controller.getRawAxis(Constants.RIGHT_TRIGGER)*Constants.INTAKE_SPEED); //positive
    }

    public void IntakeCube(XboxController controller) {
        intake1.set(controller.getRawAxis(Constants.LEFT_TRIGGER)*Constants.INTAKE_SPEED); //positive
        intake2.set(controller.getRawAxis(Constants.LEFT_TRIGGER)*Constants.INTAKE_SPEED); //positive
    }

    public void ReleaseCone(XboxController controller) {
        intake1.set(controller.getRawAxis(Constants.LEFT_TRIGGER)*Constants.INTAKE_SPEED); //positive
        intake2.set(-controller.getRawAxis(Constants.LEFT_TRIGGER)*Constants.INTAKE_SPEED); //negative
    }

    public void ReleaseCube(XboxController controller) {
        intake1.set(-controller.getRawAxis(Constants.LEFT_TRIGGER)*Constants.INTAKE_SPEED); //negative
        intake2.set(-controller.getRawAxis(Constants.LEFT_TRIGGER)*Constants.INTAKE_SPEED); //negative
    }

    public void stop() {
        intake1.set(0.0);
        intake2.set(0.0);
    }
}