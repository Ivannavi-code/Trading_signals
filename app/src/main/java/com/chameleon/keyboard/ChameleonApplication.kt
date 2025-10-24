package com.chameleon.keyboard

import android.app.Application
import android.util.Log

class ChameleonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        setupExceptionHandler()
        
        Log.d(TAG, "Chameleon Keyboard v1.0.0 initialized")
    }

    private fun setupExceptionHandler() {
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Log.e(TAG, "Uncaught exception in thread ${thread.name}", throwable)
            defaultHandler?.uncaughtException(thread, throwable)
        }
    }

    companion object {
        private const val TAG = "ChameleonApp"
    }
}
