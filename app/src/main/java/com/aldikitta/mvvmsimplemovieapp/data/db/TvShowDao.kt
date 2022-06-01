package com.aldikitta.mvvmsimplemovieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvshows: List<TvShow>)

    @Query("DELETE FROM popular_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_shows")
    suspend fun getTvShows(): List<TvShow>
}