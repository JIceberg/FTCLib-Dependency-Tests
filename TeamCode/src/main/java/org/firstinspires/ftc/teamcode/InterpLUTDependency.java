package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.util.InterpLUT;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class InterpLUTDependency extends LinearOpMode {

    private InterpLUT interpLUT;

    @Override
    public void runOpMode() throws InterruptedException {
        interpLUT = new InterpLUT();
        interpLUT.add(3, 2);
    }

}
