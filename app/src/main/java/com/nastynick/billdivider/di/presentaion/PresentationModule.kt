package com.nastynick.billdivider.di.presentaion

import androidx.fragment.app.FragmentActivity
import com.nastynick.billdivider.presentation.service.LocationService
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Module
class PresentationModule(
        private val activity: FragmentActivity,
        private val containerId: Int
) {

    @PresentationScope
    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @PresentationScope
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @PresentationScope
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @PresentationScope
    @Provides
    fun provideNavigator(): Navigator = SupportAppNavigator(activity, activity.supportFragmentManager, containerId)

    @PresentationScope
    @Provides
    fun provideLocationService(): LocationService = LocationService(activity)

    @Provides
    fun provideRxPermissions(): RxPermissions {
        val currentFragment = activity.supportFragmentManager.findFragmentById(containerId)
        return if (currentFragment != null) {
            RxPermissions(currentFragment)
        } else {
            RxPermissions(activity)
        }
    }
}