package com.sithuhein.mm.hanacodetest.presentation.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sithuhein.mm.hanacodetest.data.local.ApplicationDatabase
import com.sithuhein.mm.hanacodetest.data.local.dao.CachedDao
import com.sithuhein.mm.hanacodetest.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ApplicationDatabase {
        return Room.databaseBuilder(
            context,
            ApplicationDatabase::class.java,
            "app_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCachedDao(database: ApplicationDatabase) : CachedDao {
        return database.cachedDao()
    }

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}