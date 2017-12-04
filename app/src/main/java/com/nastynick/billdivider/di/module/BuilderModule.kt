package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.root.RootActivity
import dagger.Module

@Module
abstract class BuilderModule{

    abstract fun bindRootActivity() : RootActivity
}