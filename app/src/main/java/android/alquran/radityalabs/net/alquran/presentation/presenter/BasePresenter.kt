package android.alquran.radityalabs.net.alquran.presentation.presenter

import android.alquran.radityalabs.net.alquran.presentation.rx.RxBus
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import io.reactivex.SingleTransformer
import io.reactivex.functions.Consumer

/**
 * Created by radityagumay on 8/12/17.
 */
open class BasePresenter<V : BaseView> {
    lateinit protected var view: V

    protected var mCompositeSubscription: CompositeDisposable? = null

    protected fun dispose() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription!!.clear()
        }
    }

    protected fun addDisposable(subscription: Disposable) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeDisposable()
        }
        mCompositeSubscription!!.add(subscription)
    }

    protected fun <U> addRxBusSubscribe(eventType: Class<U>, act: Consumer<U>) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeDisposable()
        }
        mCompositeSubscription!!.add(RxBus.default.toDefaultObservable(eventType, act))
    }

    open fun attachView(view: V) {
        this.view = view
    }

    open fun detachView() {
        dispose()
    }

    fun bindLifeCycle(lifeCycle: SingleTransformer<*, *>) {
        //this.transformations.lifecycle = lifeCycle
    }
}
