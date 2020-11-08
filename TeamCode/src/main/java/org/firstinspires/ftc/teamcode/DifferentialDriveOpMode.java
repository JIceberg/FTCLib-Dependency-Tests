package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="diffy sux")
public class DifferentialDriveOpMode extends LinearOpMode {

    Motor fL, fR, bL, bR;
    DifferentialDrive drive;
    MotorGroup left, right;
    GamepadEx driverOp;

    @Override
    public void runOpMode() throws InterruptedException {
        fL = new Motor(hardwareMap, "fL");
        fR = new Motor(hardwareMap, "fR");
        bL = new Motor(hardwareMap, "bL");
        bR = new Motor(hardwareMap, "bR");
        left = new MotorGroup(fL, bL);
        right = new MotorGroup(fR, bR);
        drive = new DifferentialDrive(false, left, right);
        driverOp = new GamepadEx(gamepad1);
        waitForStart();
        while (opModeIsActive()) {
            drive.tankDrive(driverOp.getLeftY(), driverOp.getRightY());
        }
    }

}
