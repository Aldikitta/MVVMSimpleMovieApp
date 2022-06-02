package com.aldikitta.mvvmsimplemovieapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.GetTvShowUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.UpdateTvShowUseCase

class TvShowViewModel (
    private val getTvShowsUseCase: GetTvShowUseCase,
    private val updateTvShowsUseCase: UpdateTvShowUseCase
) : ViewModel() {
    fun getTvShows() = liveData {
        val tvshowList = getTvShowsUseCase.execute()
        emit(tvshowList)
    }

    fun updateTvShows() = liveData {
        val tvshowList = updateTvShowsUseCase.execute()
        emit(tvshowList)
    }
}
