package android.alquran.radityalabs.net.alquran.presentation.presenter.contract

import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.presentation.presenter.BasePresenter
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView

/**
 * Created by radityagumay on 8/12/17.
 */
interface SurahContract {
    interface View : BaseView {
        fun loadSurahSuccess(listOfSurah: List<SurahData>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadSurah()
    }
}