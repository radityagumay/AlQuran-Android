package android.alquran.radityalabs.net.alquran.presentation.presenter.contract

import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import android.alquran.radityalabs.net.alquran.presentation.presenter.BasePresenter
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import io.reactivex.Single

/**
 * Created by radityagumay on 8/12/17.
 */
interface SurahContract {
    interface View : BaseView {
        fun loadSurahSuccess(surahList: List<SurahResponse>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadSurah(): Single<SurahResponse>
    }
}