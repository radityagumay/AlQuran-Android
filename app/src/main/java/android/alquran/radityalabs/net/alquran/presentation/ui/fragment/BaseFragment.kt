package android.alquran.radityalabs.net.alquran.presentation.ui.fragment

import android.alquran.radityalabs.net.alquran.App
import android.alquran.radityalabs.net.alquran.presentation.di.component.DaggerFragmentComponent
import android.alquran.radityalabs.net.alquran.presentation.di.component.FragmentComponent
import android.alquran.radityalabs.net.alquran.presentation.di.module.FragmentModule
import android.alquran.radityalabs.net.alquran.presentation.presenter.BasePresenter
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import javax.inject.Inject

/**
 * Created by radityagumay on 8/12/17.
 */
abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : RxFragment(), BaseView {

    @Inject
    lateinit var presenter: P

    protected val fragmentComponent: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(FragmentModule(this))
                .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection()
        setupEvent()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.bindLifeCycle(RxLifecycleAndroid.bindFragment<Any>(lifecycle()))
        setupView()
        presenter.attachView(this as V)
        setupData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    protected abstract fun setupInjection()

    protected abstract fun setupEvent()

    protected abstract fun getLayoutId(): Int

    protected abstract fun setupView()

    protected abstract fun setupData()
}
