package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "forevantwocontrolhubs (Blocks to Java)")
public class forevantwocontrolhubs extends LinearOpMode {

  private DcMotor armmoter;
  private Servo Rightservo;
  private Servo leftservo;
  private DcMotor leftmoter;
  private DcMotor rightmoter;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double armPower;
    double TurningPower;
    double tgtPower;
    double leftServoPower;
    double rightServoPower;

    armmoter = hardwareMap.get(DcMotor.class, "arm moter");
    Rightservo = hardwareMap.get(Servo.class, "Right servo");
    leftservo = hardwareMap.get(Servo.class, "left servo");
    leftmoter = hardwareMap.get(DcMotor.class, "left moter");
    rightmoter = hardwareMap.get(DcMotor.class, "right moter");

    waitForStart();
    armmoter.setDirection(DcMotorSimple.Direction.REVERSE);
    Rightservo.setDirection(Servo.Direction.REVERSE);
    leftservo.setDirection(Servo.Direction.REVERSE);
    // Put initialization blocks here.
    while (opModeIsActive()) {
      tgtPower = gamepad1.left_stick_y * 0.75;
      leftmoter.setPower(-tgtPower);
      rightmoter.setPower(tgtPower);
      TurningPower = gamepad1.right_stick_x * 0.75;
      armPower = -(gamepad2.right_stick_y * 0.75);
      leftServoPower = -(gamepad2.left_trigger * 0.75);
      rightServoPower = -(gamepad2.right_trigger * 0.75);
      rightmoter.setPower(TurningPower);
      leftmoter.setPower(TurningPower);
      armmoter.setPower(armPower);
      leftservo.setPosition(leftServoPower);
      Rightservo.setPosition(rightServoPower);
      telemetry.update();
    }
  }
}
