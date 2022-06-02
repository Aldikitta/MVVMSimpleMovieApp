package com.aldikitta.mvvmsimplemovieapp.presentation.di.core

import com.aldikitta.mvvmsimplemovieapp.data.api.TMDBService
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasourceimplement.ArtistRemoteDataSourceImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasourceimplement.MovieRemoteDataSourceImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasourceimplement.TvShowRemoteDataSourceImplement
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val apiKey: String
) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImplement(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImplement(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImplement(
            tmdbService, apiKey
        )
    }
}