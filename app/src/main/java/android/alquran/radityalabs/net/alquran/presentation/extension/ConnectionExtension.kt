package android.alquran.radityalabs.net.alquran.presentation.extension

import android.alquran.radityalabs.net.alquran.App
import android.annotation.SuppressLint
import android.content.Context
import android.net.NetworkInfo
import android.net.ConnectivityManager

/**
 * Created by radityagumay on 8/12/17.
 */
interface ConnectionExtension {
    fun isWifiConnected(): Boolean {
        val connectivityManager = App.instance?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).state
        return wifi == NetworkInfo.State.CONNECTED
    }

    fun isMobileNetworkConnected(): Boolean {
        val connectivityManager = App.instance?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state
        return mobile == NetworkInfo.State.CONNECTED
    }

    fun isNetworkConnected(): Boolean {
        var netstate = false
        val connectivity = App.instance?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.allNetworkInfo
        if (info != null) {
            for (anInfo in info) {
                if (anInfo.state == NetworkInfo.State.CONNECTED) {
                    netstate = true
                    break
                }
            }
        }
        return netstate
    }
}