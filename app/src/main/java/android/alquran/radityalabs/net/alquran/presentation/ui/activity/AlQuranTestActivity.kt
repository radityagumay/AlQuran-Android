package android.alquran.radityalabs.net.alquran.presentation.ui.activity

import android.alquran.radityalabs.net.alquran.R
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout

/**
 * Created by radityagumay on 8/13/17.
 */
@VisibleForTesting
class AlQuranTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this)
        frameLayout.id = R.id.container
        setContentView(frameLayout)
    }
}