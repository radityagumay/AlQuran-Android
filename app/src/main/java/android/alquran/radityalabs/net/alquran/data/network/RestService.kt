package android.alquran.radityalabs.net.alquran.data.network

import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by radityagumay on 8/12/17.
 */
interface RestService {
    @GET(ApiConstant.SURAH)
    fun loadSurah(): Single<SurahResponse>
}