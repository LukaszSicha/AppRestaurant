package ie.wit.apprestaurant.main

import android.util.Log
import android.app.Application

class AppRestaurant : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.v("Donate","Donation App started")
    }
}