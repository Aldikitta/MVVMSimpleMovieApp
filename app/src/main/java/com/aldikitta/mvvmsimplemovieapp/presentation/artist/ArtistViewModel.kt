package com.aldikitta.mvvmsimplemovieapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aldikitta.mvvmsimplemovieapp.domain.artist.GetArtistUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.artist.UpdateArtistUseCase


class ArtistViewModel(
    private val getArtistsUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistUseCase
) : ViewModel() {
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}