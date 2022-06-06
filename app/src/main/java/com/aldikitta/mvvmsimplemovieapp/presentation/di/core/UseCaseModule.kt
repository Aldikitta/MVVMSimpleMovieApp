package com.aldikitta.mvvmsimplemovieapp.presentation.di.core

import com.aldikitta.mvvmsimplemovieapp.domain.artist.ArtistRepository
import com.aldikitta.mvvmsimplemovieapp.domain.artist.GetArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.artist.UpdateArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.movie.GetMoviesUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.movie.MovieRepository
import com.aldikitta.mvvmsimplemovieapp.domain.movie.UpdateMovieUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.GetTvShowUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.TvShowRepository
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

}