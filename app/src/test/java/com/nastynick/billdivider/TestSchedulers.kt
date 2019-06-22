package com.nastynick.billdivider

import com.nastynick.billdivider.data.schedulers.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulers : SchedulersProvider {

    override fun ui(): Scheduler = TestScheduler()

    override fun computation(): Scheduler = TestScheduler()

    override fun io(): Scheduler = TestScheduler()
}