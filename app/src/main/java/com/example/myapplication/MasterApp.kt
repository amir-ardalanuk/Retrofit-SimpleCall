package com.example.myapplication

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication

 class MasterApplication : MultiDexApplication() {


    //  private var mTracker: Tracker? = null
    // private var mFirebaseAnalytics: FirebaseAnalytics? = null

     companion object{
         private var sInstance: MasterApplication? = null
         fun getInstance(): MasterApplication? {
             return sInstance
         }
     }


    override fun onCreate() {
        super.onCreate()
        sInstance = this
        Log.d("MasterApplication", "onCreate: ")
//        SQLiteDatabase.loadLibs(this)
//        getDefaultTracker().enableAdvertisingIdCollection(true)
//        getDefaultTracker().enableAutoActivityTracking(true)
//        getDefaultTracker().enableExceptionReporting(true)
//        initFabric()
//        initAnalytic()
//        Metrix.initialize(this, "oeswputestzbnzt")
//        // OneSignal Initialization
//        OneSignal.startInit(this)
//            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//            .unsubscribeWhenNotificationsAreDisabled(true)
//            .init()
//        Stetho.initializeWithDefaults(this)
//        UserLocationHelper.getInstance().initGoogleApiClient()
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
//        initImageLoader()
    }
}