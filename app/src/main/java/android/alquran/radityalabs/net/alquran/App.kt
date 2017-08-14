package android.alquran.radityalabs.net.alquran

import android.app.Application
import android.alquran.radityalabs.net.alquran.presentation.di.module.HttpModule
import android.alquran.radityalabs.net.alquran.presentation.di.module.AppModule
import android.alquran.radityalabs.net.alquran.presentation.di.component.AppComponent
import android.alquran.radityalabs.net.alquran.presentation.di.component.DaggerAppComponent
import io.realm.Realm

/**
 * Created by radityagumay on 8/12/17.
 */
class App : Application() {
    companion object {
        var instance: App? = null
            private set
        var sAppComponent: AppComponent? = null
            private set

        fun getAppComponent(): AppComponent? {
            if (sAppComponent == null) {
                sAppComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(instance))
                        .httpModule(HttpModule())
                        .build()
            }
            return sAppComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Realm.init(this)
    }
}
