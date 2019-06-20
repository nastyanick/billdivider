package com.nastynick.billdivider.presentation.base

import com.arellomobile.mvp.MvpAppCompatFragment
import com.nastynick.billdivider.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator

open class BaseFragment : MvpAppCompatFragment() {

    protected val navigator by lazy {
        SupportAppNavigator(requireActivity(), childFragmentManager, R.id.container)
    }
}