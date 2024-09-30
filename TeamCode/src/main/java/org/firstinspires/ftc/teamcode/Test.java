package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Test", group = "Test")
public class Test extends LinearOpMode {
    private DcMotor fL, fR, bL, bR;

    @Override
    public void runOpMode() {
        fL = hardwareMap.get(DcMotor.class, "FL");
        fR = hardwareMap.get(DcMotor.class, "FR");
        bL = hardwareMap.get(DcMotor.class, "BL");
        bR = hardwareMap.get(DcMotor.class, "BR");

        waitForStart();

        while (opModeIsActive()) {
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            double strafe = gamepad1.left_stick_x;

            fL.setPower(forward + turn + strafe);
            fR.setPower(forward - turn - strafe);
            bL.setPower(forward + turn - strafe);
            bR.setPower(forward - turn + strafe);
        }
    }
}
