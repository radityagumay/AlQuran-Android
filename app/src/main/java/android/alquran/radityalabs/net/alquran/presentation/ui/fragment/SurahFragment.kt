package android.alquran.radityalabs.net.alquran.presentation.ui.fragment

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.presentation.di.module.SurahModule
import android.alquran.radityalabs.net.alquran.presentation.presenter.SurahPresenter
import android.os.Bundle
import android.view.View

/**
 * Created by radityagumay on 8/12/17.
 */
class SurahFragment : BaseFragment<SurahPresenter>() {
    companion object {
        val TAG = SurahFragment::class.java.simpleName

        fun newInstance() = SurahFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showError(message: String) {

    }

    override fun setupInjection() {
        fragmentComponent.plus(SurahModule()).inject(this)
    }

    override fun setupEvent() {

    }

    override fun getLayoutId() = R.layout.fragment_surah

    override fun setupView() {
        setupRecycleView()
    }

    override fun setupData() {
        mPresenter.loadSurah()
    }

    private fun setupRecycleView() {

    }
}