package com.example.easysushi.di

import com.example.easysushi.data.repository.WaresRepositoryImpl
import com.example.easysushi.domain.repository.WaresRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindWaresRepoImpl(waresRepositoryImpl: WaresRepositoryImpl): WaresRepository
}
