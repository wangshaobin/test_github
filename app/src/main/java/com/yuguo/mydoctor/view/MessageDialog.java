package com.yuguo.mydoctor.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yuguo.mydoctor.R;

/**
 * 提醒对话框
 * 
 * @author Administrator
 * 
 */
public class MessageDialog extends Dialog {
	private TextView mTvMessage;
	private CharSequence mMsg = "";
    private Button btnOk;
    private Button btnCancel;

	public MessageDialog(Context context, CharSequence message, boolean cancel,
                         View.OnClickListener sureListener,
                         View.OnClickListener cancelListener) {
		super(context, R.style.AlertDialogTheme);
		mMsg = message;
		init(cancel, sureListener, cancelListener);
	}

	public void setMsg(CharSequence message) {
		this.mMsg = message;
		mTvMessage.setText(mMsg);
	}

    public void setBack(String back){
        btnCancel.setText(back);
    }

    public void setCall(String call){
        btnOk.setText(call);
    }

	private void init(boolean cancel, View.OnClickListener sureListener,
			View.OnClickListener cancelListener) {
		setContentView(R.layout.dialog_message);
		mTvMessage = (TextView) findViewById(R.id.tv_message);
		btnOk = (Button) findViewById(R.id.btn_ok);
		btnCancel = (Button) findViewById(R.id.btn_cancel);
		if (cancel) {
			btnCancel.setVisibility(View.VISIBLE);
			btnCancel.setOnClickListener(cancelListener);
		} else {
			btnCancel.setVisibility(View.GONE);
		}
		btnOk.setOnClickListener(sureListener);
		mTvMessage.setText(mMsg);
	}
}
