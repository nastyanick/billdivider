package com.nastynick.billdivider.data.schedulers

import io.reactivex.Scheduler

interface SchedulersProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
}