package com.nastynick.billdivider.presentation.uikit

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import com.gordonwong.materialsheetfab.AnimatedFab

class AnimatedFloatingActionButton : FloatingActionButton, AnimatedFab {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun show(translationX: Float, translationY: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}