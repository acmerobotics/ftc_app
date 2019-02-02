package org.firstinspires.ftc.robotcontroller.internal;

import android.util.Log;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;

public class CameraFrameGrabber implements CameraBridgeViewBase.CvCameraViewListener {

    private static CameraFrameGrabber instance = new CameraFrameGrabber();

    private Mat frame, overlay;

    private CameraFrameGrabber () {

    }

    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public synchronized Mat onCameraFrame(Mat inputFrame) {
        frame = inputFrame;
        if (overlay == null) {
//            Log.i("opencv", "returning default frame");
            return frame;
        }
        return overlay;
    }

    public synchronized Mat getFrame() {
        return frame;
    }

    public synchronized void setOverlay(Mat mat) {
        overlay = mat;
    }

    public static CameraFrameGrabber getInstance () {
        return instance;
    }

}
