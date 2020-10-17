package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "USE THIS ONE!!!!", group = "TeleOp")
public class MainDriver extends LinearOpMode {

    private DcMotor br;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor fl;
    private DcMotor arm;
    private DcMotor pinion;
    private DcMotor clamp;


      /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        br = hardwareMap.dcMotor.get("br");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        fl = hardwareMap.dcMotor.get("fl");
        arm = hardwareMap.dcMotor.get("arm");
        pinion = hardwareMap.dcMotor.get("pinion");
        clamp = hardwareMap.dcMotor.get("clamp");



        // Reverse one of the drive motors.
        br.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                fr.setPower(gamepad1.left_stick_y);
                bl.setPower(gamepad1.left_stick_y);
                fl.setPower(gamepad1.left_stick_y);
                br.setPower(gamepad1.left_stick_y);
                if (gamepad1.dpad_right) {
                    fr.setPower(1);
                    bl.setPower(1);
                    fl.setPower(-1);
                    br.setPower(-1);
                }
                if (gamepad1.dpad_left) {
                    fr.setPower(-1);
                    bl.setPower(-1);
                    fl.setPower(1);
                    br.setPower(1);
                }
                if (gamepad1.right_bumper) {
                    fr.setPower(1);
                    bl.setPower(-1);
                    fl.setPower(-1);
                    br.setPower(1);
                }
                if (gamepad1.left_bumper) {
                    fr.setPower(-1);
                    bl.setPower(1);
                    fl.setPower(1);
                    br.setPower(-1);
                }
                if(gamepad1.left_trigger > 0){
                    arm.setPower(gamepad1.left_trigger);
                }
                if(gamepad1.right_trigger > 0) {
                    arm.setPower(-gamepad1.right_trigger);
                }
                if(gamepad1.x) {
                    pinion.setPower(1);
                }
                if(gamepad1.b) {
                    pinion.setPower(-1);
                }
                if (gamepad1.y){
                    clamp.setPower(1.0);
                }
                if (gamepad1.x){
                    clamp.setPower(0.0);
                }
                else{
                    pinion.setPower(0);
                    arm.setPower(0);
                    clamp.setPower(0);
                }
            }
        }
    }
}