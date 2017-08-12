package android.alquran.radityalabs.net.alquran.data.network.interceptor

import android.alquran.radityalabs.net.alquran.presentation.extension.ConnectionExtension
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by radityagumay on 8/12/17.
 */
class CacheInterceptor : Interceptor, ConnectionExtension {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request = chain?.request()
        if (!isNetworkConnected()) {
            request = request?.newBuilder()
                    ?.cacheControl(CacheControl.FORCE_CACHE)
                    ?.build()
        }
        val response = chain?.proceed(request)
        if (isNetworkConnected()) {
            val maxAge = 0
            response?.newBuilder()
                    ?.header("Cache-Control", "public, max-age=" + maxAge)
                    ?.removeHeader("Pragma")
                    ?.build()
        } else {
            val maxStale = 60 * 60 * 24 * 28
            response?.newBuilder()
                    ?.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    ?.removeHeader("Pragma")
                    ?.build()
        }
        return response
    }
}
