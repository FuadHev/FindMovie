package com.fuadhev.findmovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fuadhev.findmovie.R
import com.fuadhev.findmovie.utils.Constant
import  com.fuadhev.findmovie.model.Result
import com.fuadhev.findmovie.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieClickListener: MovieClickListener,private var movieList:List<Result>):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {



    inner class  ViewHolder(val view:MovieItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = MovieItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  movieList.size
    }


    fun updateMovieList(newList:List<Result>){
        this.movieList=newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie=movieList[position]
        val b=holder.view

        b.movieCard.setOnClickListener {
            movieClickListener.movieClickListener(movie.id)
        }

        b.movieTitle.text=movie.title
        Picasso.get().load("${Constant.IMAGE_BASE_URL}${movie.poster_path}").into(b.poster)
    }


}
interface MovieClickListener{
    fun movieClickListener(movie_id:Int)
}