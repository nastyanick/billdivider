package com.nastynick.billdivider.di.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun providesRouter(): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    fun providesNavigatorHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}