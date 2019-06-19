package com.nastynick.billdivider

import leakcanary.LeakCanary

class DebugBillDividerApplication : BillDividerApplication() {

    override fun onCreate() {
        super.onCreate()
        initLeakCanary()
    }

    private fun initLeakCanary() {
        LeakCanary.config = LeakCanary.config.copy(retainedVisibleThreshold = 1)
    }
}