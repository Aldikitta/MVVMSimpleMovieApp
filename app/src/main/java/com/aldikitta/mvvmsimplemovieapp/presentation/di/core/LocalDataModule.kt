package com.aldikitta.mvvmsimplemovieapp.presentation.di.core

import com.aldikitta.mvvmsimplemovieapp.data.db.ArtistDao
import com.aldikitta.mvvmsimplemovieapp.data.db.MovieDao
import com.aldikitta.mvvmsimplemovieapp.data.db.TvShowDao
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasourceimplement.ArtistLocalDataSourceImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasourceimplement.MovieLocalDataSourceImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasourceimplement.TvShowLocalDataSourceImplement
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImplement(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImplement(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImplement(tvShowDao)
    }
}