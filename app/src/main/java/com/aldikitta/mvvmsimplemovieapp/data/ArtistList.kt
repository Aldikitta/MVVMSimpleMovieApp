package com.aldikitta.mvvmsimplemovieapp.data


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>,

)