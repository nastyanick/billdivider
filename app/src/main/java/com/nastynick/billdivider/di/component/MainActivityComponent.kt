package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.di.module.MainActivityModule
import com.nastynick.billdivider.presentation.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun injectMainActivity(activity: MainActivity)
}
