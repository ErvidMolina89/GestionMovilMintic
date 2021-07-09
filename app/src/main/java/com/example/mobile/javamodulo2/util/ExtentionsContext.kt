package com.example.mobile.javamodulo2.util

import android.content.Context
import android.net.ConnectivityManager

fun Context.isNetworkAvailable(): Boolean{
    try {
        val connectivityManager =
                this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    } catch (e: Exception) {
        return false
    }
}