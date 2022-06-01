package com.aldikitta.mvvmsimplemovieapp.domain.artist

import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist

class UpdateArtistUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}