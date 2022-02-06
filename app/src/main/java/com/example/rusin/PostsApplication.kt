package com.example.rusin

import android.app.Application
import com.example.rusin.di.interactorModule
import com.example.rusin.di.networkModule
import com.example.rusin.di.repositoryModule
import com.example.rusin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PostsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PostsApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    interactorModule
                )
            )
        }
    }
}