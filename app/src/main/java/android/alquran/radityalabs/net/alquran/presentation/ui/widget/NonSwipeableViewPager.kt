package android.alquran.radityalabs.net.alquran.presentation.ui.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by radityagumay on 8/13/17.
 */
class NonSwipeableViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    private var enabledSwipe: Boolean = true

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (this.enabledSwipe) {
            return super.onTouchEvent(event)
        }
        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (this.enabledSwipe) {
            return super.onInterceptTouchEvent(event)
        }

        return false
    }

    fun setPagingEnabled(enabled: Boolean) {
        this.enabledSwipe = enabled
    }
}