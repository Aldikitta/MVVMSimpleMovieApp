package com.aldikitta.mvvmsimplemovieapp.domain.tvshow

import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow

class GetTvShowUseCase (
    private val tvShowRepository: TvShowRepository
) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()

}