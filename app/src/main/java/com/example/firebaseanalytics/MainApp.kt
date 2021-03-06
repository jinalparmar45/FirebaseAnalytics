package com.example.firebaseanalytics

import android.app.Application
import timber.log.Timber

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format(
                        "Class ${super.createStackElementTag(element)} :" +
                                " Line ${element.lineNumber}  Method ${element.methodName}"
                    )
                }
            })
            //How your debug messages can be styled or even added more meta data

        } else {
            // build a custom class ReleaseTree and then make it act as an inceptor which will
            //collect all your logs and puts it to crashlytics
            Timber.plant(ReleaseTree())
        }
    }
}
class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        //        if(priority == Log.ERROR || priority == Log.WARN){
//
//        }
        // send the error reports to crashlytics
    }

}
