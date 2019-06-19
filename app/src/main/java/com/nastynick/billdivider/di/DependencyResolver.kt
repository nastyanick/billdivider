package com.nastynick.billdivider.di

import android.app.Application
import com.nastynick.billdivider.di.application.ApplicationComponent
import com.nastynick.billdivider.di.application.ApplicationModule
import com.nastynick.billdivider.di.application.DaggerApplicationComponent
import com.nastynick.billdivider.di.application.RoomModule
import com.nastynick.billdivider.di.presentaion.PresentationComponent

object DependencyResolver {
    private lateinit var applicationComponent: ApplicationComponent

    fun plusApplicationComponent(application: Application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .roomModule(RoomModule())
                .build()
    }

    fun presentationComponent(): PresentationComponent {
        return applicationComponent.presentationComponent()
    }
}