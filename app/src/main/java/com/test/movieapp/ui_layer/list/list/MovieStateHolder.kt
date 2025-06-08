package com.test.movieapp.ui_layer.list.list

import com.test.movieapp.model.Movie

data class MovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
