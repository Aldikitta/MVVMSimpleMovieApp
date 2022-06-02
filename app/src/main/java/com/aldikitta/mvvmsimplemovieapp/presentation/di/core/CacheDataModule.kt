package com.aldikitta.mvvmsimplemovieapp.presentation.di.core

import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasourceimplement.ArtistCacheDataSourceImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasourceimplement.MovieCacheDataSourceImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasourceimplement.TvShowCacheDataSourceImplement
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImplement()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImplement()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImplement()
    }
}