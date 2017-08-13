package android.alquran.radityalabs.net.alquran.presentation.ui.fragment

import android.alquran.radityalabs.net.alquran.App
import android.alquran.radityalabs.net.alquran.presentation.di.component.DaggerFragmentComponent
import android.alquran.radityalabs.net.alquran.presentation.di.component.FragmentComponent
import android.alquran.radityalabs.net.alquran.presentation.di.module.FragmentModule
import android.alquran.radityalabs.net.alquran.presentation.presenter.BasePresenter
import android.alquran.radityalabs.net.alquran.presentation.rx.RxPresenter
import android.alquran.radityalabs.net.alquran.presentation.view.BaseView
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

/**
 * Created by radityagumay on 8/12/17.
 */
abstract class BaseFragment<V : BaseView, P : RxPresenter<V>> : Fragment(), BaseView {

    @Inject
    lateinit var mPresenter: P

    protected var mView: View? = null
    protected var mActivity: Activity? = null
    protected var mContext: Context? = null

    protected val fragmentComponent: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(FragmentModule(this))
                .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupEvent()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this as V)
        setupView()
        setupData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    protected abstract fun setupInjection()

    protected abstract fun setupEvent()

    protected abstract fun getLayoutId(): Int

    protected abstract fun setupView()

    protected abstract fun setupData()
}
