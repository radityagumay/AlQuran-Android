package android.alquran.radityalabs.net.alquran.presentation.ui.widget

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.presentation.annotation.FontFamily
import android.alquran.radityalabs.net.alquran.presentation.annotation.FontStyle
import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * Created by radityagumay on 8/13/17.
 * https://android.jlelse.eu/building-custom-component-with-kotlin-fc082678b080
 */
class RTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.RTextView, 0, 0)
            val fontFamily = typedArray.getInt(R.styleable.RTextView_fontFamilyType, FontFamily.ROBOTO.toInt()).toLong()
            val fontStyle = typedArray.getInt(R.styleable.RTextView_fontStyleType, FontStyle.REGULAR.toInt()).toLong()
            setupFont(fontFamily.toInt())
            typedArray.recycle()
        }
    }

    private fun setupFont(fontFamily: Int) {
        var fontName: String = "fonts/Roboto-Regular.ttf"
        when (fontFamily.toLong()) {
            FontFamily.ROBOTO -> {
                fontName = "fonts/Roboto-Regular.ttf"
            }
        }
        typeface = Typeface.createFromAsset(context.assets, fontName)
    }
}