package android.alquran.radityalabs.net.alquran.data.database

import android.alquran.radityalabs.net.alquran.BuildConfig
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.rx.RealmObservableFactory

/**
 * Created by radityagumay on 8/12/17.
 */
class RealmHelper {
    companion object {
        private val DATABASE_NAME = "AlQuran.realm"
        private val SCHEMA_VERSION = 1L
    }

    fun buildRealmConfiguration(): RealmConfiguration {
        if (BuildConfig.DEBUG) {
            return RealmConfiguration.Builder()
                    .name(DATABASE_NAME)
                    .schemaVersion(SCHEMA_VERSION)
                    .deleteRealmIfMigrationNeeded()
                    .rxFactory(RealmObservableFactory())
                    .build()
        } else {
            return RealmConfiguration.Builder()
                    .name(DATABASE_NAME)
                    .schemaVersion(SCHEMA_VERSION)
                    .encryptionKey(BuildConfig.REALM_KEY.toByteArray())
                    .rxFactory(RealmObservableFactory())
                    .build()
        }
    }
}

inline fun Realm.transaction(body: (Realm) -> Unit) {
    beginTransaction()
    body(this)
    commitTransaction()
}