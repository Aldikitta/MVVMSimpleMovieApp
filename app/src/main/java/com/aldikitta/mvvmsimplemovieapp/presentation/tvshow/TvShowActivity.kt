package com.aldikitta.mvvmsimplemovieapp.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aldikitta.mvvmsimplemovieapp.R
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityMovieBinding
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}