package com.aldikitta.mvvmsimplemovieapp.domain.tvshow

import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}