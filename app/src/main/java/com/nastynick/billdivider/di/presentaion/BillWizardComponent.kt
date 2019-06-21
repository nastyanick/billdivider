package com.nastynick.billdivider.di.presentaion

import com.nastynick.billdivider.presentation.billwizard.details.BillWizardDetailsFragment
import com.nastynick.billdivider.presentation.billwizard.flow.BillWizardFlowActivity
import com.nastynick.billdivider.presentation.billwizard.position.BillWizardPositionFragment
import com.nastynick.billdivider.presentation.billwizard.positions.BillWizardPositionsFragment
import com.nastynick.billdivider.presentation.billwizard.summary.BillWizardSummaryFragment
import dagger.Subcomponent

@BillWizardScope
@Subcomponent
interface BillWizardComponent {

    fun inject(billWizardFlowActivity: BillWizardFlowActivity)

    fun inject(billWizardPositionFragment: BillWizardPositionFragment)

    fun inject(billWizardPositionsFragment: BillWizardPositionsFragment)

    fun inject(billWizardSummaryFragment: BillWizardSummaryFragment)

    fun inject(billWizardDetailsFragment: BillWizardDetailsFragment)

}