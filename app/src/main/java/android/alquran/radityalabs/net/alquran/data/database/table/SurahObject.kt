package android.alquran.radityalabs.net.alquran.data.database.table

import io.realm.RealmObject

/**
 * Created by radityagumay on 8/13/17.
 */
open class SurahObject : RealmObject() {
    var id: Long? = null
    var name: String? = null
    var englishName: String? = null
    var englishNameTranslation: String? = null
    var numberOfAyahs: Long? = null
    var revelationType: String? = null
}