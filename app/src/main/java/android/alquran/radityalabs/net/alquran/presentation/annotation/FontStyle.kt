package android.alquran.radityalabs.net.alquran.presentation.annotation

import android.support.annotation.IntDef

/**
 * Created by radityagumay on 8/13/17.
 */
class FontStyle {
    companion object {
        const val REGULAR = 0L
    }

    @IntDef(REGULAR)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Type
}