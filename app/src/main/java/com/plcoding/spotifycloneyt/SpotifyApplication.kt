package com.plcoding.spotifycloneyt

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpotifyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}