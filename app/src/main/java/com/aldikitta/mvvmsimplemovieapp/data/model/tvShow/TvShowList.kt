package com.aldikitta.mvvmsimplemovieapp.data.model.tvShow


import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>,

    )