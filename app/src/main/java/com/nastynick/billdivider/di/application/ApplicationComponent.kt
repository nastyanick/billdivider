package com.nastynick.billdivider.di.application

import com.nastynick.billdivider.di.presentaion.PresentationComponent
import com.nastynick.billdivider.di.presentaion.PresentationModule
import dagger.Component

@ApplicationScope
@Component(
        modules = [
            ApplicationModule::class,
            RoomModule::class,
            RepositoryModule::class
        ]
)

interface ApplicationComponent {

    fun presentationComponent(presentationModule: PresentationModule): PresentationComponent
}