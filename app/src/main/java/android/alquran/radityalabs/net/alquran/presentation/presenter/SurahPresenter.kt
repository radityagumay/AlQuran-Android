package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import android.alquran.radityalabs.net.alquran.presentation.presenter.contract.SurahContract
import android.alquran.radityalabs.net.alquran.presentation.rx.RxPresenter
import io.reactivex.Single

/**
 * Created by radityagumay on 8/12/17.
 */
class SurahPresenter : RxPresenter<SurahContract.View>(), SurahContract.Presenter {


    override fun loadSurah(): Single<SurahResponse> {

    }
}