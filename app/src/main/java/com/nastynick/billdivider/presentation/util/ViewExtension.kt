package com.nastynick.billdivider.presentation.util

import android.view.View

fun View.setVisibleElseGone(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}