package android.alquran.radityalabs.net.alquran.presentation.ui.fragment

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.presentation.adapter.SurahAdapter
import android.alquran.radityalabs.net.alquran.presentation.di.module.SurahModule
import android.alquran.radityalabs.net.alquran.presentation.presenter.SurahPresenter
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_surah.*

class SurahFragment : BaseFragment<SurahPresenter.View, SurahPresenter>(), SurahPresenter.View {
    companion object {
        val TAG = SurahFragment::class.java.simpleName

        fun newInstance() = SurahFragment()
    }

    private lateinit var surahAdapter: SurahAdapter

    override fun onLoadSurahSuccess(listOfSurah: List<SurahData>) {
        Log.d(TAG, listOfSurah.toString())
        surahAdapter.setNotifyDataChanges(listOfSurah)
    }

    override fun setupInjection() {
        fragmentComponent.plus(SurahModule()).inject(this)
    }

    override fun setupEvent() {
        surahAdapter = SurahAdapter()
    }

    override fun getLayoutId() = R.layout.fragment_surah

    override fun setupView() {
        surah.adapter = surahAdapter
        surah.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun setupData() {
        presenter.onLoadSurah()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}