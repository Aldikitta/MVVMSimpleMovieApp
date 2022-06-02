package com.aldikitta.mvvmsimplemovieapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aldikitta.mvvmsimplemovieapp.R
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityArtistBinding
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityTvShowBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}