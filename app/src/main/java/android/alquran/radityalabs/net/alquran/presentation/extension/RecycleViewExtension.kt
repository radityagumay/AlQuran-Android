package android.alquran.radityalabs.net.alquran.presentation.extension

import android.content.Context
import android.support.v7.widget.LinearLayoutManager

/**
 * Created by radityagumay on 8/13/17.
 */
interface RecycleViewExtension {
    fun linearLayoutManager(context: Context): LinearLayoutManager {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.reverseLayout = false
        linearLayoutManager.stackFromEnd = true
        return linearLayoutManager
    }

    fun simpleLinearLayoutManager(context: Context): LinearLayoutManager {
        val linearLayoutManager = LinearLayoutManager(context)
        return linearLayoutManager
    }
}
