package android.alquran.radityalabs.net.alquran.presentation.di.component

import android.alquran.radityalabs.net.alquran.App
import android.alquran.radityalabs.net.alquran.data.database.RealmHelper
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.data.network.RetrofitHelper
import android.alquran.radityalabs.net.alquran.presentation.di.module.AppModule
import android.alquran.radityalabs.net.alquran.presentation.di.module.HttpModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by radityagumay on 8/12/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface AppComponent {
    fun context(): App?
    fun retrofitHelper(): RetrofitHelper
    fun realmHelper(): RealmHelper
    fun restService(): RestService
}