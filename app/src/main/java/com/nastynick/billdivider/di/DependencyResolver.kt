package com.nastynick.billdivider.di

import android.app.Application
import com.nastynick.billdivider.di.component.*
import com.nastynick.billdivider.di.module.ApplicationModule
import com.nastynick.billdivider.di.module.RoomModule

object DependencyResolver {
    private lateinit var applicationComponent: ApplicationComponent
    private var presentationComponent: PresentationComponent? = null

    fun plusApplicationComponent(application: Application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .roomModule(RoomModule())
                .build()
    }


    fun presentationComponent(): PresentationComponent {
        return presentationComponent
                ?: applicationComponent.presentationComponent()
                        .also { presentationComponent = it }
    }
}