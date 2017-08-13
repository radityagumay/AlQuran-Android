package android.alquran.radityalabs.net.alquran.presentation.adapter

import android.alquran.radityalabs.net.alquran.presentation.ui.fragment.SurahFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by radityagumay on 8/13/17.
 */
class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return SurahFragment.newInstance()
            1 -> return SurahFragment.newInstance()
        }
        return SurahFragment.newInstance()
    }

    override fun getCount(): Int {
        return 2
    }
}
