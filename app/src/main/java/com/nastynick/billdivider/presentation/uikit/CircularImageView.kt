package com.nastynick.billdivider.presentation.uikit

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.nastynick.billdivider.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_circular_image_view.view.*
import java.util.*

class CircularImageView : FrameLayout {

    private val backgrounds = arrayOf(
            R.drawable.background_circular_image_view_circle_blue,
            R.drawable.background_circular_image_view_circle_green,
            R.drawable.background_circular_image_view_circle_pink,
            R.drawable.background_circular_image_view_circle_purple)

    private val random = Random()

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

    private fun init(context: Context, attrs: AttributeSet? = null) {
        LayoutInflater.from(context).inflate(R.layout.view_circular_image_view, this)

        val styledAttrs = context.theme.obtainStyledAttributes(attrs, R.styleable.CircleImageView, 0, 0)
        viewCircularImageViewFrameLayoutBorder.background = when (BorderColor.from(styledAttrs)) {
            CircularImageView.BorderColor.RANDOM -> getBorderBackground()
            CircularImageView.BorderColor.PRIMARY -> resources.getDrawable(R.drawable.background_circular_image_view_circle_green)
        }

        styledAttrs.recycle()
    }

    private fun getBorderBackground(): Drawable {
        return random.nextInt(backgrounds.size)
                .let { backgrounds[it] }
                .let(resources::getDrawable)
    }

    fun setImage(source: String?) {
        Picasso.with(context)
                .load(source)
                .placeholder(R.drawable.ic_friend)
                .into(circularImageView)
    }

    private enum class BorderColor(private val index: Int) {
        RANDOM(0), PRIMARY(1);

        companion object {
            fun from(attrs: TypedArray): BorderColor {
                val index = attrs.getInt(R.styleable.CircularImageView_border_color, PRIMARY.index)
                return values().first { it.index == index }
            }
        }
    }
}
