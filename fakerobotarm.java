package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "fakerobotarm (Blocks to Java)")
public class fakerobotarm extends LinearOpMode {

  private DcMotor armboyAsDcMotor;
  private Servo RightpincherAsServo;
  private Servo leftpincherAsServo;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double armPower;
    float rightServoPower;
    float leftServoPower;

    armboyAsDcMotor = hardwareMap.get(DcMotor.class, "armboyAsDcMotor");
    RightpincherAsServo = hardwareMap.get(Servo.class, "RightpincherAsServo");
    leftpincherAsServo = hardwareMap.get(Servo.class, "leftpincherAsServo");

    // Put initialization blocks here.
    waitForStart();
    armboyAsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        // Put loop blocks here.
        RightpincherAsServo.setDirection(Servo.Direction.REVERSE);
        leftpincherAsServo.setDirection(Servo.Direction.FORWARD);
        armPower = -(gamepad1.right_stick_y * 0.75);
        rightServoPower = gamepad1.right_trigger + 0;
        leftServoPower = gamepad1.right_trigger - 0;
        armboyAsDcMotor.setPower(armPower);
        RightpincherAsServo.setPosition(rightServoPower);
        leftpincherAsServo.setPosition(leftServoPower);
        // Put run blocks here.
        telemetry.update();
      }
    }
  }
}
