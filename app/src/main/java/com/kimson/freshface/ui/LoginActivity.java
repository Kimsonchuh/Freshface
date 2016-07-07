package com.kimson.freshface.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.isnc.facesdk.SuperID;
import com.isnc.facesdk.common.Cache;
import com.isnc.facesdk.common.SDKConfig;
import com.kimson.freshface.R;
import com.kimson.freshface.ui.base.BaseActivity;
import com.kimson.library.widget.Toaster;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhujianheng on 7/7/16.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = LoginActivity.class.getSimpleName();

    private Button mLogout;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLogin = (Button) findViewById(R.id.login);
        mLogout = (Button) findViewById(R.id.logout);
        mLogin.setOnClickListener(this);
        mLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                SuperID.faceLogin(this);
                break;
            case R.id.logout:
                SuperID.faceLogout(this);
                Toaster.showShort(this, "退出登录成功");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case SDKConfig.AUTH_SUCCESS:
                String openid = Cache.getCached(this, SDKConfig.KEY_OPENID);
                String userInfo = Cache.getCached(this, SDKConfig.KEY_APPINFO);
                Log.e(TAG, "userInfo" + JSON.toJSONString(userInfo));
                break;
            case SDKConfig.LOGINSUCCESS:
                String Loginopenid = Cache.getCached(this, SDKConfig.KEY_OPENID);
                String LoginuserInfo = Cache.getCached(this, SDKConfig.KEY_APPINFO);
                Log.e(TAG, "LoginuserInfo" + JSON.toJSONString(LoginuserInfo));
                break;
            default:
                break;
        }
    }

}
