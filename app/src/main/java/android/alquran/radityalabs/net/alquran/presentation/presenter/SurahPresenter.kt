package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.domain.SurahRepository
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import javax.inject.Inject

class SurahPresenter @Inject constructor(val repository: SurahRepository) :
        BasePresenter<SurahPresenter.View>() {

    fun onLoadSurah() {
        val disposable = repository.onLoadSurah().subscribe({
            success ->
            view.onLoadSurahSuccess(success.data)
        }, {
            error ->
            view.showError(error.message!!)
        })
        addDisposable(disposable)
    }

    interface View : BaseView {
        fun onLoadSurahSuccess(listOfSurah: List<SurahData>)
    }
}