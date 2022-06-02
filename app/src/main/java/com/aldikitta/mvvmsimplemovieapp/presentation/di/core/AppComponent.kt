package com.aldikitta.mvvmsimplemovieapp.presentation.di.core

import com.aldikitta.mvvmsimplemovieapp.presentation.di.artist.ArtistSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.movie.MovieSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory
}