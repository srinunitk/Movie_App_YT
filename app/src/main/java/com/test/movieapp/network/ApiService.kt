package com.test.movieapp.network

import com.test.movieapp.model.Movie
import com.test.movieapp.model.MovieListResponse
import com.test.movieapp.model.details.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    // https://api.themoviedb.org/3/movie/popular?api_key=%3Capi_key%3E

    // https://api.themoviedb.org/3/movie/76600?api_key=

    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey:String
    ):MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id:String,
        @Query("api_key") apiKey: String
    ):MovieDetails

}
