package android.alquran.radityalabs.net.alquran.presentation.ui.activity

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.presentation.adapter.MainPagerAdapter
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    companion object {
        val TAG = MainActivity::class.java
    }

    private lateinit var mainPagerAdapter: MainPagerAdapter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_surah -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setupViewPager() {
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        container.adapter = mainPagerAdapter
        container.setPagingEnabled(false)
    }
}
