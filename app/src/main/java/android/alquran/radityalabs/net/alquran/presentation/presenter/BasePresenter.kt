package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.presentation.view.BaseView

/**
 * Created by radityagumay on 8/12/17.
 */
interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)

    fun detachView()
}
