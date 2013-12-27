package com.example.djinspect;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Mat;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;

public class MainActivity extends Activity implements CvCameraViewListener2 {

	static {
		System.loadLibrary("opencv_java");
	}

	private CameraBridgeViewBase mOpenCvCameraView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("oncreate", "called onCreate");
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		setContentView(R.layout.activity_main);

		mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.camView);
		mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
		mOpenCvCameraView.setCvCameraViewListener(this);

	}

	@Override
	public void onPause() {
		super.onPause();
		if (mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	public void onDestroy() {
		super.onDestroy();
		if (mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	public void onCameraViewStarted(int width, int height) {
		Log.i("CameraStart", "camera started");
	}

	public void onCameraViewStopped() {
		Log.i("CameraStop", "camera stopped");
	}

	public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
		Log.i("CameraFrame", "new frame");
		return inputFrame.rgba();
	}

	/*
	 * Size mPreviewSize; Mat mCurrentFrame; Bitmap bitFrame; SurfaceView
	 * previewIv; ProgressBar progBar; Button goNoGoBox; CameraBridgeViewBase
	 * mOpenCvCameraView;
	 * 
	 * Timer imgTimer;
	 * 
	 * 
	 * Runnable updateImage = new Runnable() {
	 * 
	 * @Override public void run() { } };
	 * 
	 * TimerTask updateTask = new TimerTask() {
	 * 
	 * @Override public void run() { if(previewIv != null && mCurrentFrame !=
	 * null) { Utils.matToBitmap(mCurrentFrame, bitFrame);
	 * runOnUiThread(updateImage); } } };
	 * 
	 * 
	 * @Override protected void onCreate(Bundle savedInstanceState) {
	 * 
	 * super.onCreate(savedInstanceState);
	 * setContentView(R.layout.activity_main);
	 * 
	 * progBar = (ProgressBar)findViewById(R.id.progressBar2); goNoGoBox =
	 * (Button)findViewById(R.id.StatusBlock);
	 * 
	 * mOpenCvCameraView = (CameraBridgeViewBase)
	 * findViewById(R.id.surfaceView1);
	 * mOpenCvCameraView.setCvCameraViewListener(this);
	 * 
	 * imgTimer = new Timer(); imgTimer.schedule(updateTask, 33);
	 * 
	 * }
	 * 
	 * 
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 * 
	 * 
	 * 
	 * public Mat onCameraFrame(Mat newFrame) { Log.i("onFrame",
	 * "onCameraFrame"); return newFrame; }
	 * 
	 * public void onCameraViewStarted(int width, int height) {
	 * Log.i("Cv_start", "onCameraViewStart"); }
	 * 
	 * public void onCameraViewStopped() { Log.i("Cv_stop",
	 * "onCameraViewStopped"); }
	 * 
	 * 
	 * private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this)
	 * {
	 * 
	 * @Override public void onManagerConnected(int status) { switch (status) {
	 * case LoaderCallbackInterface.SUCCESS: { Log.i("CvLoader",
	 * "OpenCV loaded successfully"); mOpenCvCameraView.enableView(); } break;
	 * default: { super.onManagerConnected(status); } break; } } };
	 * 
	 * @Override public void onResume() { super.onResume();
	 * OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_6, this,
	 * mLoaderCallback); }
	 */

}
