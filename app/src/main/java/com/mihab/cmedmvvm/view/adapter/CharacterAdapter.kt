package com.mihab.cmedmvvm.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mihab.cmedmvvm.R
import com.mihab.cmedmvvm.databinding.ItemMovieBinding
import com.mihab.cmedmvvm.service.model.Character

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var characterList = ArrayList<Character>()
    private lateinit var onClickListener: OnClickListener

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList: List<Character>) {
        this.characterList = movieList as ArrayList<Character>
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

        val character = characterList[position]

        holder.binding.apply {
            Glide.with(holder.itemView)
                .load(character.image)
                .placeholder(R.drawable.ic_placeholder)
                .into(ivMovieImage)

            tvName.text = "Name: ${character.name}"
            tvActorName.text = "Actor Name: ${character.actor}"
            tvHouseName.text = "House Name: ${character.house}"
        }

        holder.itemView.setOnClickListener {
            onClickListener.onClick(position, character)
        }


    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, movie: Character)
    }

}
