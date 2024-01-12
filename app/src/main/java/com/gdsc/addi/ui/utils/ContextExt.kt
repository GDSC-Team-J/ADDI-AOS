package com.gdsc.addi.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun Context.isNetworkConnected(): Boolean {
    var isConnected = false
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = cm.getNetworkCapabilities(cm.activeNetwork)
    if (capabilities != null) {
        isConnected = isConnectedToWiFi(capabilities) || isConnectedToCellular(capabilities)
    }
    return isConnected
}

private fun isConnectedToWiFi(capabilities: NetworkCapabilities): Boolean {
    return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
}

private fun isConnectedToCellular(capabilities: NetworkCapabilities): Boolean {
    return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
}