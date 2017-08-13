package android.alquran.radityalabs.net.alquran.base

import android.support.test.rule.ActivityTestRule
import android.support.v4.app.Fragment
import org.junit.Assert
import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.presentation.ui.activity.AlQuranTestActivity

/**
 * Created by radityagumay on 8/13/17.
 */
class FragmentTestRule<F : Fragment>(private val mFragmentClass: Class<F>) : ActivityTestRule<AlQuranTestActivity>(AlQuranTestActivity::class.java, true, false) {
    var fragment: F? = null
        private set

    override fun afterActivityLaunched() {
        super.afterActivityLaunched()

        activity.runOnUiThread({
            try {
                val manager = activity.supportFragmentManager
                val transaction = manager.beginTransaction()
                fragment = mFragmentClass.newInstance()
                transaction.replace(R.id.container, fragment)
                transaction.commit()
            } catch (e: InstantiationException) {
                Assert.fail(String.format("%s: Could not insert %s into TestActivity: %s",
                        javaClass.simpleName,
                        mFragmentClass.simpleName,
                        e.message))
            } catch (e: IllegalAccessException) {
                Assert.fail(String.format("%s: Could not insert %s into TestActivity: %s", javaClass.simpleName, mFragmentClass.simpleName, e.message))
            }
        })
    }
}