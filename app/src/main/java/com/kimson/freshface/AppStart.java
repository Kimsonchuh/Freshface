package com.kimson.freshface;

import android.os.Bundle;
import android.view.animation.Animation;

import com.isnc.facesdk.SuperID;
import com.kimson.freshface.ui.HomeActivity;
import com.kimson.freshface.ui.LoginActivity;
import com.kimson.freshface.util.ActivityUtils;
import com.kimson.library.ui.StartUpActivity;

/**
 * Created by zhujianheng on 7/7/16.
 */
public class AppStart extends StartUpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

    }
    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        ActivityUtils.goHome(this, LoginActivity.class);
    }

}
