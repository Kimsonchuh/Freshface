package com.kimson.freshface;

import com.isnc.facesdk.SuperID;
import com.kimson.library.Application;

/**
 * Created by zhujianheng on 7/7/16.
 */
public class KCApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SuperID.initFaceSDK(this);
        SuperID.setDebugMode(true);
        AppConfig.initialize(this);
    }
}
