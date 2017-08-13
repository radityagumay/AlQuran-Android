package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.domain.SurahUseCase
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import javax.inject.Inject

/**
 * Created by radityagumay on 8/12/17.
 */
class SurahPresenter @Inject constructor(val usecase: SurahUseCase) :
        BasePresenter<SurahPresenter.View>() {

    fun onLoadSurah() {
        val disposable = usecase.onLoadSurah().subscribe({
            success ->
            view.loadSurahSuccess(success.data)
        }, {
            error ->
            view.showError(error.message!!)
        })
        addDisposable(disposable)
    }

    interface View : BaseView {
        fun loadSurahSuccess(listOfSurah: List<SurahData>)
    }
}