package com.nastynick.billdivider.presentation.base

import com.arellomobile.mvp.MvpAppCompatFragment
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.ComponentsHolder

open class BaseFragment : MvpAppCompatFragment() {

    fun getComponent() = ComponentsHolder.presentationComponent(requireActivity(), R.id.container)

}