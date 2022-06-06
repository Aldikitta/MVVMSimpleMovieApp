package com.aldikitta.mvvmsimplemovieapp.presentation.di.core

import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.ArtistRepositoryImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.MovieRepositoryImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.TvShowRepositoryImplement
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.domain.artist.ArtistRepository
import com.aldikitta.mvvmsimplemovieapp.domain.movie.MovieRepository
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImplement(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ): ArtistRepository {
        return ArtistRepositoryImplement(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )

    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImplement(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )

    }
}