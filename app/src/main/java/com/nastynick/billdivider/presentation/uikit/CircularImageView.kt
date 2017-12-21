package com.nastynick.billdivider.presentation.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.nastynick.billdivider.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_circular_image_view.view.*

class CircularImageView : FrameLayout {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    fun init(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.view_circular_image_view, this)
    }

    fun setImage(source: String?) {
        Picasso.with(context).load(source).placeholder(R.drawable.ic_friend).into(circularImageView)
    }
}
