package com.aldikitta.mvvmsimplemovieapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aldikitta.mvvmsimplemovieapp.domain.artist.GetArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.artist.UpdateArtistUseCase

class ArtistViewModelFactory (
    private val getArtistsUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }

}