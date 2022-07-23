package com.sithuhein.mm.hanacodetest.presentation.di


import com.sithuhein.mm.hanacodetest.data.repository.MainRepositoryImpl
import com.sithuhein.mm.hanacodetest.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun bindMainRepository(impl: MainRepositoryImpl): MainRepository
}