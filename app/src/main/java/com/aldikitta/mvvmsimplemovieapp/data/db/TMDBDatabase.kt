package com.aldikitta.mvvmsimplemovieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist
import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie
import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TvShowDao
}