package gaur.himanshu.movieapp.data

import gaur.himanshu.movieapp.network.ApiService

class MovieDatasource(private val apiService: ApiService) {

    val apiKey = "3b808e8aa6a692fce76e4c986503c72c"
    suspend fun getMovieList() = apiService.getMovieList(apiKey = apiKey)

    suspend fun getMovieDetails(id: String) = apiService.getMovieDetails(id, apiKey = apiKey)

}