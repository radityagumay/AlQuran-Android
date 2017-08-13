package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.domain.SurahUseCase
import android.alquran.radityalabs.net.alquran.presentation.presenter.contract.SurahContract
import android.alquran.radityalabs.net.alquran.presentation.rx.RxPresenter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by radityagumay on 8/12/17.
 */
@Singleton
class SurahPresenter @Inject constructor(val usecase: SurahUseCase) :
        RxPresenter<SurahContract.View>(), SurahContract.Presenter {
    override fun loadSurah() {
        val disposable = usecase.onLoadSurah().subscribe({
            success ->
            mView?.loadSurahSuccess(success.data)
        }, {
            error ->
            mView?.showError(error.message!!)
        })
        addDisposable(disposable)
    }
}