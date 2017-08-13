package android.alquran.radityalabs.net.alquran.presentation.di.component

import android.alquran.radityalabs.net.alquran.presentation.di.module.SurahModule
import android.alquran.radityalabs.net.alquran.presentation.ui.fragment.SurahFragment
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by radityagumay on 8/13/17.
 */
@Singleton
@Subcomponent(modules = arrayOf(SurahModule::class))
interface SurahComponent {
    fun inject(fragment: SurahFragment)
}