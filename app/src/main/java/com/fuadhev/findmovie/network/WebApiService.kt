package com.fuadhev.findmovie.network

import com.fuadhev.findmovie.model.MovieResponse
import com.fuadhev.findmovie.model.MovieResponseById
import com.fuadhev.findmovie.model.MovieVideoResponseById
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface WebApiService {


    //  Bearer den sonra sizde olan size aid kodu yazmalisiz

    @Headers("accept:application/json",
        "Authorization:Bearer Your key")
    @GET("movie/popular")
    suspend fun getPopularMovies(
                          @Query("language") lan:String="en-US",
                          @Query("page") page: Int=1): Response<MovieResponse>


    @Headers("accept:application/json",
        "Authorization:Bearer Your key")
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") lan:String="en-US",
        @Query("page") page: Int=1): Response<MovieResponse>


    @Headers("accept:application/json",
        "Authorization:Bearer Your key")
    @GET("movie/upcoming")
    suspend fun getUpComingMovies(
        @Query("language") lan:String="en-US",
        @Query("page") page: Int=1): Response<MovieResponse>


    @Headers("accept:application/json",
        "Authorization:Bearer Your key")
    @GET("movie/{id}")
    suspend fun movieMovieById(
        @Path("id") movie_id:Int,
        @Query("language") lan:String="en-US",
        @Query("page") page: Int=1): Response<MovieResponseById>


    @Headers("accept:application/json",
        "Authorization:Bearer Your key")
    @GET("movie/{id}/videos")
    suspend fun getMovieVideosById(
        @Path("id") movie_id:Int,
        @Query("language") lan:String="en-US"
        ): Response<MovieVideoResponseById>

}