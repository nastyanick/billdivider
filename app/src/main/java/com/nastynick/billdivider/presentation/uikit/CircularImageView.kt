package com.nastynick.billdivider.presentation.uikit

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.nastynick.billdivider.R
import kotlinx.android.synthetic.main.view_circular_image_view.view.*

class CircularImageView : FrameLayout {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs, defStyleAttr, defStyleRes)
    }

    fun init(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) {
        LayoutInflater.from(context).inflate(R.layout.view_circular_image_view, this)
        setDefaultImage()
    }

    fun setImage(source: String?) {
        if (source != null) {
            setImageFromSource(source)
        } else {
            setDefaultImage()
        }
    }

    private fun setDefaultImage() {
        Glide.with(this).load(ContextCompat.getDrawable(context, R.drawable.ic_friend)).into(circularImageView)
    }

    private fun setImageFromSource(source: String) {
        Glide.with(this).load(source).into(circularImageView)
    }

}
