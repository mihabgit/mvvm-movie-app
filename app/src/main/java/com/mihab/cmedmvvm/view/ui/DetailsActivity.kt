package com.mihab.cmedmvvm.view.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mihab.cmedmvvm.R
import com.mihab.cmedmvvm.databinding.ActivityDetailsBinding
import com.mihab.cmedmvvm.service.model.Movie

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        var characterDetails : Movie? = null
        if (intent.hasExtra("character-details")) {
            characterDetails = intent.getParcelableExtra("character-details", Movie::class.java)
        }

        if (characterDetails != null) {
            binding.apply {
                tvActor.text = "Actor: ${characterDetails.actor}"
                tvName.text = "Name: ${characterDetails.name}"
                tvBirthday.text = "Date of Birth: ${characterDetails.dateOfBirth}"
                tvHouse.text = "House: ${characterDetails.house}"
                tvGender.text = "Gender: ${characterDetails.gender}"
                tvSpecies.text = "Species: ${characterDetails.species}"

                Glide.with(this@DetailsActivity)
                    .load(characterDetails.image)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(ivMovieImage)
            }
        }


    }


}