package com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImplement : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}