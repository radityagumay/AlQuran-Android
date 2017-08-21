package android.alquran.radityalabs.net.alquran.domain

import android.alquran.radityalabs.net.alquran.data.database.RealmHelper
import android.alquran.radityalabs.net.alquran.data.database.table.SurahObject
import android.alquran.radityalabs.net.alquran.data.database.transaction
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import android.alquran.radityalabs.net.alquran.presentation.annotation.TestOpen
import android.alquran.radityalabs.net.alquran.presentation.rx.RxExtension
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmList

@TestOpen
class SurahRepository(val service: RestService, val realm: RealmHelper) : RxExtension {
    companion object {
        val TAG = SurahRepository::class.java.simpleName
    }

    fun onLoadSurah(): Single<SurahResponse> {
        return service.loadSurah()
                .compose { upstream ->
                    upstream.doOnSuccess { response ->
                        val r = Realm.getInstance(realm.buildRealmConfiguration())
                        r.transaction {
                            val obj = RealmList<SurahObject>()
                            for (i in 0..response.data.size - 1) {
                                val item = SurahObject()
                                item.id = (i + 1).toLong()
                                item.name = response.data[i].name
                                item.englishName = response.data[i].englishName
                                item.englishNameTranslation = response.data[i].englishNameTranslation
                                item.numberOfAyahs = response.data[i].numberOfAyahs.toLong()
                                item.revelationType = response.data[i].revelationType
                                obj.add(item)
                            }
                        }
                    }
                }
                .compose(singleNewThread())
                .compose(reportLog(TAG))
    }
}