package android.alquran.radityalabs.net.alquran.presentation.ui.widget

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.presentation.annotation.FontFamily
import android.alquran.radityalabs.net.alquran.presentation.annotation.FontStyle
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by radityagumay on 8/13/17.
 * https://android.jlelse.eu/building-custom-component-with-kotlin-fc082678b080
 */
class RTextView : TextView {

    private var attrs: AttributeSet? = null
    private var fontFamily: Long = FontFamily.ROBOTO
    private var fontStyle: Long = FontStyle.REGULAR

    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr) {
        this.attrs = attrs
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
            context: Context,
            attrs: AttributeSet?,
            defStyleAttr: Int,
            defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes) {
        this.attrs = attrs
    }

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.RTextView, 0, 0)
            fontFamily = typedArray.getInt(R.styleable.RTextView_fontFamily, FontFamily.ROBOTO.toInt()).toLong()
            fontStyle = typedArray.getInt(R.styleable.RTextView_fontType, FontStyle.REGULAR.toInt()).toLong()
            typedArray.recycle()
        }
    }
}