package org.tec.datos.packettecapp.register;

import android.app.Application;

import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Gerald on 11/12/2017.
 */

public class MyApp extends Application {
    public void onCreate(){
        super.onCreate();
        AppEventsLogger.activateApp(this);

    }
}
