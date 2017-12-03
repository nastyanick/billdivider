package com.nastynick.billdivider.di.component

import android.app.Application
import com.nastynick.billdivider.BillDividerApplication
import com.nastynick.billdivider.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ApplicationModule::class, ActivityBuilderModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: BillDividerApplication)

}