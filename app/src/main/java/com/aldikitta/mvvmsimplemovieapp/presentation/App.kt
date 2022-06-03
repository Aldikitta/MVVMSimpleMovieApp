package com.aldikitta.mvvmsimplemovieapp.presentation

import android.app.Application
import com.aldikitta.mvvmsimplemovieapp.BuildConfig
import com.aldikitta.mvvmsimplemovieapp.presentation.di.Injector
import com.aldikitta.mvvmsimplemovieapp.presentation.di.artist.ArtistSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.core.*

import com.aldikitta.mvvmsimplemovieapp.presentation.di.movie.MovieSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.tvshow.TvShowSubComponent

//import com.anushka.tmdbclient.presentation.di.core.DaggerAppComponent


class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

//    override fun createMovieSubComponent(): MovieSubComponent {
//        TODO("Not yet implemented")
//    }
//
//    override fun createTvShowSubComponent(): TvShowSubComponent {
//        TODO("Not yet implemented")
//    }
//
//    override fun createArtistSubComponent(): ArtistSubComponent {
//        TODO("Not yet implemented")
//    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()

    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}