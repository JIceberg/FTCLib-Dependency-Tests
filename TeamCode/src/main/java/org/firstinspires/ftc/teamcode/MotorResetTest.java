package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Reset Motor Test")
public class MotorResetTest extends LinearOpMode {

    private Motor motor;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = new Motor(hardwareMap, "test");
        waitForStart();
        while (opModeIsActive()) {
            motor.resetEncoder();
            if (gamepad1.a) motor.set(0.6);
            else motor.stopMotor();
            telemetry.addData("Encoder reading", motor.getCurrentPosition());
            telemetry.update();
        }
        motor.stopMotor();
    }

}
