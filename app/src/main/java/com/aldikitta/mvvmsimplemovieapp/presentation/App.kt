package com.aldikitta.mvvmsimplemovieapp.presentation

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.aldikitta.mvvmsimplemovieapp.presentation.di.Injector
import com.aldikitta.mvvmsimplemovieapp.presentation.di.artist.ArtistSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.core.AppComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.core.AppModule
import com.aldikitta.mvvmsimplemovieapp.presentation.di.core.NetModule
import com.aldikitta.mvvmsimplemovieapp.presentation.di.core.RemoteDataModule
import com.aldikitta.mvvmsimplemovieapp.presentation.di.movie.MovieSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.tvshow.TvShowSubComponent

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
    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")

    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }
}