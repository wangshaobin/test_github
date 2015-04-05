package com.yuguo.mydoctor.main.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chinaway.framework.swordfish.util.NetWorkDetectionUtils;
import com.chinaway.framework.swordfish.util.PackageInfoUtils;
import com.yuguo.mydoctor.R;
import com.yuguo.mydoctor.view.MessageDialog;

public class SplashActivity extends Activity {
	private static final String TAG = "SplashActivity";
	private Context mContext;
	private MessageDialog mMessageDialog;
	private TextView mTvVersionName;
	private TextView mTvMessage;
	private ProgressBar mPbLoading;
	private ProgressBar mPbDownloadApk;
	private String mNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mContext = this;
		View view = View.inflate(mContext, R.layout.activity_splash, null);
		setContentView(view);

        initView(view);
        initAnim(view);
	}

    private void initView(View view) {
        mTvVersionName = (TextView) view.findViewById(R.id.tv_version_name);
        mTvVersionName.setText(PackageInfoUtils.getVersionName(mContext));

        mTvMessage = (TextView) view.findViewById(R.id.tv_message);
        mPbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
        mPbDownloadApk = (ProgressBar) view.findViewById(R.id.pb_download_apk);

        mMessageDialog = new MessageDialog(getApplicationContext(), "错误", false,
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mMessageDialog.dismiss();
                        finish();
                    }
                }, null);
        mMessageDialog.setCancelable(false);
    }

    private void initAnim(View view) {
        Animation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(1000);
        animation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (NetWorkDetectionUtils.checkNetworkAvailable(getApplicationContext())) {
                    mPbLoading.setVisibility(View.VISIBLE);
                    mTvMessage.setVisibility(View.VISIBLE);
                    mTvMessage.setText("正在获取配置...");
                    syncAppConfig();
                } else {
//                    userLogin();
                    syncAppConfig();
                }
            }
        });

        view.setAnimation(animation);
    }

    private void syncAppConfig(){
        Intent intent=new Intent(mContext, MainActivity.class);
        startActivity(intent);
        finish();
    }
}