package com.aldikitta.mvvmsimplemovieapp.presentation.di.artist

import com.aldikitta.mvvmsimplemovieapp.domain.artist.GetArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.artist.UpdateArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}