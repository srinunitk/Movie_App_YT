package com.test.movieapp.ui_layer.list.details

import com.test.movieapp.model.details.MovieDetails

data class MovieDetailsStateHolder(
    val isLoading:Boolean= false,
    val data:MovieDetails?=null,
    val error:String=""
)
