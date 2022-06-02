package com.aldikitta.mvvmsimplemovieapp.presentation.di.tvshow

import com.aldikitta.mvvmsimplemovieapp.domain.artist.GetArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.artist.UpdateArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.GetTvShowUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.UpdateTvShowUseCase
import com.aldikitta.mvvmsimplemovieapp.presentation.artist.ArtistViewModelFactory
import com.aldikitta.mvvmsimplemovieapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}