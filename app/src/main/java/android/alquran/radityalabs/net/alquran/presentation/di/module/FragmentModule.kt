package android.alquran.radityalabs.net.alquran.presentation.di.module

import android.alquran.radityalabs.net.alquran.presentation.di.scope.FragmentScope
import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides

/**
 * Created by radityagumay on 8/12/17.
 */
@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    @FragmentScope
    fun provideActivity(): Activity {
        return fragment.activity
    }
}
