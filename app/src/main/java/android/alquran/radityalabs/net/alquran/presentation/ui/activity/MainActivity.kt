package android.alquran.radityalabs.net.alquran.presentation.ui.activity

import android.alquran.radityalabs.net.alquran.R
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    companion object {
        val TAG = MainActivity::class.java
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_surah -> {
                message.setText(R.string.title_surah)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_bookmark)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private val fragments = arrayOf(Pair<>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
