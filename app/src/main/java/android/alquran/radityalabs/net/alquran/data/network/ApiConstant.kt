package android.alquran.radityalabs.net.alquran.data.network

import android.alquran.radityalabs.net.alquran.App
import java.io.File

/**
 * Created by radityagumay on 8/12/17.
 */
object ApiConstant {
    val PATH_DATA = App.instance?.cacheDir?.absolutePath + File.separator + "data"
    val PATH_CACHE = PATH_DATA + "/NetCache"

    val BASE_URL = "http://api.alquran.cloud/"
    val LIST_OF_SURAH = "/surah"
}