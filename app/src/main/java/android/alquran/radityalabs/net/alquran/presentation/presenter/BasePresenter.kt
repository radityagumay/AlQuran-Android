package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import javax.inject.Inject

/**
 * Created by radityagumay on 8/12/17.
 */
open class BasePresenter<V : BaseView> @Inject constructor() {
    protected var view: V? = null

    open fun attachView(view: V) {
        this.view = view
    }

    open fun detachView() {
    }
}
