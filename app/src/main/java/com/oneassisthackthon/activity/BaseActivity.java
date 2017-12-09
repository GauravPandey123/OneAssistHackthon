package com.oneassisthackthon.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.oneassisthackthon.R;

import static com.oneassisthackthon.helper.Utility.getStringRes;

/**
 * Created by Gaurav Pandey on 09-12-2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mContext = this;
    }
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    public void showProgress() {
        showProgress(getStringRes(R.string.msg_load_default));
    }

    public void showProgress(String msg) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            dismissProgress();
        }
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    public void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void setOtherFragment(Fragment fragment) {
        // Do something
    }

}
