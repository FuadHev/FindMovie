package com.fuadhev.findmovie.repo

import androidx.lifecycle.LiveData
import com.fuadhev.findmovie.local.MovieDao
import com.fuadhev.findmovie.model.FavoritMovie
import com.fuadhev.findmovie.model.MovieResponse
import com.fuadhev.findmovie.model.MovieResponseById
import com.fuadhev.findmovie.model.MovieVideoResponseById
import com.fuadhev.findmovie.network.ApiUtils
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val db: MovieDao){
    private val api by lazy { ApiUtils.instance }

   suspend fun getPopularMovies(): Response<MovieResponse> {
      return api.getPopularMovies()
   }
   suspend fun getTopRatedMovies(): Response<MovieResponse> {
      return api.getTopRatedMovies()
   }
   suspend fun getUpcomingMovies(): Response<MovieResponse> {
      return api.getUpComingMovies()
   }
   suspend fun getMovieById(movie_id:Long): Response<MovieResponseById> {
      return api.movieMovieById(movie_id)
   }
   suspend fun getMovieVideosById(movie_id:Long): Response<MovieVideoResponseById> {
      return api.getMovieVideosById(movie_id)
   }

   suspend fun searchMovie(query:String): Response<MovieResponse> {
      return api.searchMovie(query)
   }




   fun getAllFavMovies(): LiveData<List<FavoritMovie>> {
      return db.getAllFavoriteMovies()
   }

   suspend fun insertMovieFavorite(movie:FavoritMovie){
      return db.insertFavoriteMovie(movie)
   }

   suspend fun deleteFavoriteMovie(movie:FavoritMovie){
      return db.deleteFavoriteMovie(movie)
   }

   suspend fun isMovieIdExists(movieId:Int): Boolean {
      return db.isMovieIdExists(movieId)
   }

}