package android.alquran.radityalabs.net.alquran.presentation.ui.fragment

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.presentation.adapter.SurahAdapter
import android.alquran.radityalabs.net.alquran.presentation.di.module.SurahModule
import android.alquran.radityalabs.net.alquran.presentation.extension.RecycleViewExtension
import android.alquran.radityalabs.net.alquran.presentation.presenter.SurahPresenter
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_surah.*

/**
 * Created by radityagumay on 8/12/17.
 */
class SurahFragment : BaseFragment<SurahPresenter.View, SurahPresenter>(), SurahPresenter.View,
        RecycleViewExtension {
    companion object {
        val TAG = SurahFragment::class.java.simpleName

        fun newInstance() = SurahFragment()
    }

    private lateinit var adapter: SurahAdapter

    private var listOfSurah: List<SurahData>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setupInjection() {
        fragmentComponent.plus(SurahModule()).inject(this)
    }

    override fun setupEvent() {

    }

    override fun getLayoutId() = R.layout.fragment_surah

    override fun setupView() {
        adapter = SurahAdapter(listOfSurah)
        setupRecycleView()
    }

    override fun setupData() {
        presenter.onLoadSurah()
    }

    override fun showError(message: String) {

    }

    override fun loadSurahSuccess(listOfSurah: List<SurahData>) {
        listOfSurah.plus(listOfSurah)
    }

    private fun setupRecycleView() {
        surah.setHasFixedSize(true)
        surah.layoutManager = simpleLinearLayoutManager(context)
        surah.adapter = adapter
    }
}