package com.example.rusin.di

import com.example.rusin.data.PostsRepository
import com.example.rusin.domain.interactor.PostsInteractor
import com.example.rusin.domain.repository.PostsRepositoryI
import com.example.rusin.ui.viewmodels.BestPostsViewModel
import com.example.rusin.ui.viewmodels.HotPostsViewModel
import com.example.rusin.ui.viewmodels.LatestPostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { params -> LatestPostsViewModel(params.get(), get()) }
    viewModel { params -> BestPostsViewModel(params.get(), get()) }
    viewModel { params -> HotPostsViewModel(params.get(), get()) }
}

val repositoryModule = module {
    single<PostsRepositoryI> { PostsRepository(get()) }
}

val interactorModule = module {
    factory { PostsInteractor(get()) }
}