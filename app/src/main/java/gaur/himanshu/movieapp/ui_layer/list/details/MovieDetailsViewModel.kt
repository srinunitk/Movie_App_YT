package gaur.himanshu.movieapp.ui_layer.list.details

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.movieapp.common.Resource
import gaur.himanshu.movieapp.data.MovieRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val movieDetails = mutableStateOf(MovieDetailsStateHolder())

    init {
        movieDetails.value = MovieDetailsStateHolder(isLoading = true)
        viewModelScope.launch {
            savedStateHandle.getStateFlow("id", "0").collectLatest {
                getMovieDetails(it)
            }
        }
    }

    private fun getMovieDetails(id: String) = viewModelScope.launch {
        when (val result = movieRepository.getMovieDetails(id)) {
            is Resource.Error -> {
                movieDetails.value = MovieDetailsStateHolder(error = result.message.toString())
            }

            is Resource.Success -> {
                Log.d("srini", "Movie Details: ${result.data}")
                movieDetails.value = MovieDetailsStateHolder(data = result.data)
            }

            else -> {

            }
        }

    }
}