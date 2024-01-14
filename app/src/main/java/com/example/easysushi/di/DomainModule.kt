package com.example.easysushi.di

import android.app.Application
import com.example.easysushi.EasySushiApplication
import com.example.easysushi.RootActivity
import com.example.easysushi.data.repository.WaresRepositoryImpl
import com.example.easysushi.domain.repository.WaresRepository
import com.example.easysushi.ui.wareslist.WaresViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindWaresRepoImpl(waresRepositoryImpl: WaresRepositoryImpl): WaresRepository
}
