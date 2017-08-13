package android.alquran.radityalabs.net.alquran.presentation.di.component

import android.alquran.radityalabs.net.alquran.presentation.di.module.FragmentModule
import android.alquran.radityalabs.net.alquran.presentation.di.module.SurahModule
import dagger.Component
import android.app.Activity
import android.alquran.radityalabs.net.alquran.presentation.di.scope.FragmentScope

/**
 * Created by radityagumay on 8/12/17.
 */
@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun activity(): Activity

    fun plus(module: SurahModule): SurahComponent
}
