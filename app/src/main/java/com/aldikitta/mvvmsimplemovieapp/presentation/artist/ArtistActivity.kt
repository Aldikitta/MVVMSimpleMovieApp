package com.aldikitta.mvvmsimplemovieapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldikitta.mvvmsimplemovieapp.R
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityArtistBinding
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityMovieBinding
import com.aldikitta.mvvmsimplemovieapp.databinding.ActivityTvShowBinding
import com.aldikitta.mvvmsimplemovieapp.presentation.di.Injector
import com.aldikitta.mvvmsimplemovieapp.presentation.movie.MovieAdapter
import com.aldikitta.mvvmsimplemovieapp.presentation.movie.MovieViewModel
import com.aldikitta.mvvmsimplemovieapp.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtist()
    }

    private fun displayPopularArtist() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate : MenuInflater = menuInflater
        inflate.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE

            }else{
                binding.artistProgressBar.visibility = View.GONE

            }
        })
    }
}