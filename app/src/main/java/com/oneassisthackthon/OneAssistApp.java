package com.oneassisthackthon;


import android.content.Context;

import in.editsoft.api.util.App;

/**
 * Created by Gaurav Pandey on 09-12-2017.
 */

public class OneAssistApp extends App {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

}
