package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Ethan kinda cringe")
public class SampleOpMode extends LinearOpMode {

    Motor motor;
    PIDController controller;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("hello", "hello");
        telemetry.update();
        motor = new Motor(hardwareMap, "test", Motor.GoBILDA.RPM_312);
        controller = new PIDController(0.2, 0, 0.75);
        motor.resetEncoder();
        controller.setSetPoint(10000);
        controller.calculate();
        controller.setTolerance(5);
        waitForStart();
        while (opModeIsActive() && !controller.atSetPoint()) {
            motor.set(controller.calculate(motor.getCurrentPosition()) / 10000);
            controller.clearTotalError();
            telemetry.addData("Motor position", motor.getCurrentPosition());
            telemetry.update();
        }
        motor.stopMotor();
    }

}
