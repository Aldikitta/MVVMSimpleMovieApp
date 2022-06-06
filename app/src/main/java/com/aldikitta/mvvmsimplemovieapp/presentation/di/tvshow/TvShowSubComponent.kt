package com.aldikitta.mvvmsimplemovieapp.presentation.di.tvshow

import com.aldikitta.mvvmsimplemovieapp.presentation.artist.ArtistActivity
import com.aldikitta.mvvmsimplemovieapp.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}