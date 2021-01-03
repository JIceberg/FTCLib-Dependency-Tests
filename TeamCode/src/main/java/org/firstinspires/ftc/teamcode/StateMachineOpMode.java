package org.firstinspires.ftc.teamcode;

import com.arcrobotics.fsm.StateMachine;
import com.arcrobotics.fsm.builders.StateMachineBuilder;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class StateMachineOpMode extends LinearOpMode {

    enum State {
        IDLE, DRIVING
    }

    private GamepadEx driverOp;
    private MecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MecanumDrive(
                new Motor(hardwareMap, "frontLeft"),
                new Motor(hardwareMap, "frontRight"),
                new Motor(hardwareMap, "backLeft"),
                new Motor(hardwareMap, "backRight")
        );

        driverOp = new GamepadEx(gamepad1);

        StateMachine<State> opModeLoop = new StateMachineBuilder<State>(() -> !isStopRequested())
                .startOn(State.IDLE)
                .onState(State.IDLE, this::idle)
                .transitionOn(State.DRIVING, this::isStarted)
                .onState(State.DRIVING, () -> drive.driveRobotCentric(
                        driverOp.getLeftX(),
                        driverOp.getLeftY(),
                        driverOp.getRightX()
                ))
                .build();

        while (opModeLoop.isRunning()) {
            opModeLoop.run();
        }
    }

}
