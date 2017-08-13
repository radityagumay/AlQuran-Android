package android.alquran.radityalabs.net.alquran.presentation.di.module

import android.alquran.radityalabs.net.alquran.data.database.RealmHelper
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.domain.SurahUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by radityagumay on 8/13/17.
 */
@Module
class SurahModule {
    @Singleton
    @Provides
    fun provideSurahUseCase(restService: RestService, realmHelper: RealmHelper) =
            SurahUseCase(restService, realmHelper)
}