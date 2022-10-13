package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "armgrab (Blocks to Java)")
public class armgrab extends LinearOpMode {

  private DcMotor driveleftAsDcMotor;
  private DcMotor driverightAsDcMotor;
  private Servo leftpincherAsServo;
  private Servo RightpincherAsServo;
  private DcMotor armboyAsDcMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    driveleftAsDcMotor = hardwareMap.get(DcMotor.class, "driveleftAsDcMotor");
    driverightAsDcMotor = hardwareMap.get(DcMotor.class, "driverightAsDcMotor");
    leftpincherAsServo = hardwareMap.get(Servo.class, "leftpincherAsServo");
    RightpincherAsServo = hardwareMap.get(Servo.class, "RightpincherAsServo");
    armboyAsDcMotor = hardwareMap.get(DcMotor.class, "armboyAsDcMotor");

    waitForStart();
    // Put initialization blocks here.
    driveleftAsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    driverightAsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    if (opModeIsActive()) {
      // Put run blocks here.
      leftpincherAsServo.setPosition(4);
      RightpincherAsServo.setPosition(-4);
      sleep(1000);
      armboyAsDcMotor.setPower(-1);
      sleep(500);
      driverightAsDcMotor.setPower(0.5);
      driveleftAsDcMotor.setPower(0.5);
      sleep(1000);
      driverightAsDcMotor.setPower(0);
      driveleftAsDcMotor.setPower(0);
      driverightAsDcMotor.setPower(0);
      driveleftAsDcMotor.setPower(0.5);
      sleep(500);
      driverightAsDcMotor.setPower(0);
      driveleftAsDcMotor.setPower(0);
      waitForStart();
      sleep(500);
      RightpincherAsServo.setPosition(0);
      leftpincherAsServo.setPosition(0);
      sleep(500);
      armboyAsDcMotor.setPower(1);
      driverightAsDcMotor.setPower(-0.5);
      driveleftAsDcMotor.setPower(-0.5);
    }
  }
}
