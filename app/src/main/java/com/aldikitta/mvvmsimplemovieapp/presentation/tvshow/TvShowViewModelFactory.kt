package com.aldikitta.mvvmsimplemovieapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.GetTvShowUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.UpdateTvShowUseCase


class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowUseCase,
    private val updateTvShowsUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }

}
