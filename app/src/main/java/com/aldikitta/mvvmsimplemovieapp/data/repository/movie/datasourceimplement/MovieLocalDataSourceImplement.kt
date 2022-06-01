package com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.db.MovieDao
import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImplement(
    private val movieDao: MovieDao
): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}