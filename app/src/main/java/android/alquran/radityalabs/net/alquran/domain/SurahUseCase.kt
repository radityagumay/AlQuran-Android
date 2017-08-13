package android.alquran.radityalabs.net.alquran.domain

import android.alquran.radityalabs.net.alquran.data.database.RealmHelper
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import android.alquran.radityalabs.net.alquran.presentation.rx.RxExtension
import io.reactivex.Single

/**
 * Created by radityagumay on 8/13/17.
 */
class SurahUseCase(val service: RestService, val realmHelper: RealmHelper) : RxExtension {
    fun onLoadSurah(): Single<SurahResponse> = service.loadSurah().compose(singleNewThread())
}