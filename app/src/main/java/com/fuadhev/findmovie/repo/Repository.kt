package com.fuadhev.findmovie.repo

import com.fuadhev.findmovie.model.MovieResponse
import com.fuadhev.findmovie.model.MovieResponseById
import com.fuadhev.findmovie.model.MovieVideoResponseById
import com.fuadhev.findmovie.network.ApiUtils
import retrofit2.Response

class Repository {
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
   suspend fun getMovieById(movie_id:Int): Response<MovieResponseById> {
      return api.movieMovieById(movie_id)
   }
   suspend fun getMovieVideosById(movie_id:Int): Response<MovieVideoResponseById> {
      return api.getMovieVideosById(movie_id)
   }

}