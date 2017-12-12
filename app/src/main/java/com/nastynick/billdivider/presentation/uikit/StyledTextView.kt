package com.nastynick.billdivider.presentation.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.nastynick.billdivider.R
import kotlinx.android.synthetic.main.view_text_view_regular.view.*

class StyledTextView : FrameLayout {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }


    fun setText(text: String?) {
        billDividerTextView.text = text
    }

    private fun init(context: Context, attrs: AttributeSet? = null) {
        val styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TextView)

        val fontStyle = styledAttributes.getInt(R.styleable.TextView_textStyle, 0).let(TextStyle.Companion::fromStyle)
        LayoutInflater.from(context).inflate(getLayoutResource(fontStyle), this)

        styledAttributes.getText(R.styleable.TextView_android_text).let { billDividerTextView.text = it }

        styledAttributes.recycle()
    }

    private fun getLayoutResource(textStyle: TextStyle): Int {
        return when (textStyle) {
            StyledTextView.TextStyle.REGULAR -> R.layout.view_text_view_regular
            StyledTextView.TextStyle.LARGE -> R.layout.view_text_view_large
            StyledTextView.TextStyle.MEDIUM -> R.layout.view_text_view_medium
            StyledTextView.TextStyle.TITLE -> R.layout.view_text_view_title
        }
    }

    enum class TextStyle(var index: Int) {
        REGULAR(0),
        LARGE(1),
        MEDIUM(2),
        TITLE(3);

        companion object {
            fun fromStyle(index: Int): TextStyle {
                return values().firstOrNull { it.index == index } ?: REGULAR
            }
        }
    }
}