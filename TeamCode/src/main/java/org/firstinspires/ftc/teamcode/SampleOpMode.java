package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

public class SampleOpMode extends CommandOpMode {

    @Override
    public void initialize() {
        // oh god no
        GamepadButton button =
                (GamepadButton) new GamepadButton(driverOp, GamepadKeys.Button.X, GamepadKeys.Button.Y)
                        .and(
                                new GamepadButton(toolOp, GamepadKeys.Button.A)
                                        .whenActive(new InstantCommand())
                        ).or(
                        new GamepadButton(driverOp, GamepadKeys.Button.LEFT_BUMPER)
                                .whileActiveContinuous(new InstantCommand())
                ).negate().whenActive(new InstantCommand());
    }

}
