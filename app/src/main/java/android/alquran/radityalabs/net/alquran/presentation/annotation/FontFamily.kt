package android.alquran.radityalabs.net.alquran.presentation.annotation

import android.support.annotation.IntDef

/**
 * Created by radityagumay on 8/13/17.
 */

class FontFamily {
    companion object {
        const val ROBOTO = 0L
    }

    @IntDef(ROBOTO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Type
}