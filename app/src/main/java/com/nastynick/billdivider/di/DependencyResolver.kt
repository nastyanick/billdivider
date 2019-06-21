package com.nastynick.billdivider.di

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.di.application.ApplicationComponent
import com.nastynick.billdivider.di.application.ApplicationModule
import com.nastynick.billdivider.di.application.DaggerApplicationComponent
import com.nastynick.billdivider.di.application.RoomModule
import com.nastynick.billdivider.di.presentaion.BillWizardComponent
import com.nastynick.billdivider.di.presentaion.PresentationComponent
import com.nastynick.billdivider.di.presentaion.PresentationModule

object DependencyResolver {
    private lateinit var applicationComponent: ApplicationComponent
    private var billWizardComponent: BillWizardComponent? = null

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

    fun billWizardComponent(fragmentActivity: FragmentActivity,
                            containerId: Int
    ): BillWizardComponent {
        return billWizardComponent
                ?: presentationComponent(fragmentActivity, containerId).billWizardComponent()
                        .also { billWizardComponent = it }
    }

    fun destroyBillWizardComponent() {
        billWizardComponent = null
    }
}