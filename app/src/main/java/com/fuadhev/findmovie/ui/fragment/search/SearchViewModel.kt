package com.fuadhev.findmovie.ui.fragment.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fuadhev.findmovie.repo.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import com.fuadhev.findmovie.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val repo:Repository): ViewModel() {
    val searcMovieList=MutableLiveData<List<Result>>()



    fun searchMovie(query:String){
        viewModelScope.launch(IO) {
            val response=repo.searchMovie(query)
            if (response.isSuccessful&&response.code()==200){
                val body=response.body()
                val movieList=body?.results

                if (movieList!=null){
                    searcMovieList.postValue(movieList!!)
                }

            }
        }
    }
}