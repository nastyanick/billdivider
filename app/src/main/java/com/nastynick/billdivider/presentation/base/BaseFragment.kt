package com.nastynick.billdivider.presentation.base

import com.arellomobile.mvp.MvpAppCompatFragment
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.DependencyResolver

open class BaseFragment : MvpAppCompatFragment() {

    fun getComponent() = DependencyResolver.presentationComponent(requireActivity(), R.id.container)

}