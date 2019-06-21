package com.nastynick.billdivider.di

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.nastynick.billdivider.di.application.ApplicationComponent
import com.nastynick.billdivider.di.application.ApplicationModule
import com.nastynick.billdivider.di.application.DaggerApplicationComponent
import com.nastynick.billdivider.di.application.RoomModule
import com.nastynick.billdivider.di.presentaion.PresentationComponent
import com.nastynick.billdivider.di.presentaion.PresentationModule

object DependencyResolver {
    private lateinit var applicationComponent: ApplicationComponent

    fun plusApplicationComponent(application: Application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .roomModule(RoomModule())
                .build()
    }

    fun presentationComponent(
            fragmentActivity: FragmentActivity,
            containerId: Int
    ): PresentationComponent {
        return applicationComponent.presentationComponent(PresentationModule(fragmentActivity, containerId))
    }
}