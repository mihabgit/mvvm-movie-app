package com.mihab.cmedmvvm.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mihab.cmedmvvm.R
import com.mihab.cmedmvvm.databinding.ItemMovieBinding
import com.mihab.cmedmvvm.service.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList = ArrayList<Movie>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList: List<Movie>) {
        this.movieList = movieList as ArrayList<Movie>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = movieList[position]

        holder.binding.apply {
            Glide.with(holder.itemView)
                .load(movie.image)
                .placeholder(R.drawable.ic_placeholder)
                .into(ivMovieImage)

            tvName.text = "Name: ${movie.name}"
            tvActorName.text = "Actor Name: ${movie.actor}"
            tvHouseName.text = "House Name: ${movie.house}"
        }


    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
