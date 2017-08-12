package android.alquran.radityalabs.net.alquran.presentation.di.module

import android.alquran.radityalabs.net.alquran.App
import android.alquran.radityalabs.net.alquran.data.database.RealmHelper
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.data.network.RetrofitHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by radityagumay on 8/12/17.
 */
@Module
class AppModule(val app: App? = null) {
    @Singleton
    @Provides
    fun provideAppContext() = app

    @Singleton
    @Provides
    fun provideRetrofitHelper(service: RestService) = RetrofitHelper(service)

    @Singleton
    @Provides
    fun provideRealmHelper() = RealmHelper()
}