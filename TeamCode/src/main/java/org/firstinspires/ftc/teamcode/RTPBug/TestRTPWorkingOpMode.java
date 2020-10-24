package org.firstinspires.ftc.teamcode.RTPBug;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="RTP Working")
public class TestRTPWorkingOpMode extends LinearOpMode {

    private DcMotor motor;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class, "testMotor");

        motor.setTargetPosition(1000);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        while (opModeIsActive() && motor.isBusy()) {
            motor.setPower(0.5);
        }
        motor.setPower(0);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

}
