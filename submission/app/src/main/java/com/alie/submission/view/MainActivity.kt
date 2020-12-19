package com.alie.submission.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alie.submission.viewmodel.MainViewModel
import com.alie.submission.R
import com.alie.submission.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var listAdapter : ListAdapter
    private lateinit var imgWallpaper : ImageView
    private lateinit var tvWallpaper : TextView
    private lateinit var searchView: SearchView
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        imgWallpaper = findViewById(R.id.wallpaper)
        tvWallpaper = findViewById(R.id.tvWallpaper)
        recyclerView = findViewById(R.id.recycler_view)
        searchView = findViewById(R.id.searchView)
        recyclerView.setHasFixedSize(true)

        listAdapter = ListAdapter(this)
        searchUser()
        showRecyclerView()

        imgSettingMain.setOnClickListener {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
    }
    private fun showRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            listAdapter = ListAdapter(this@MainActivity)
            adapter = listAdapter
        }
    }
    private fun searchUser(){

        searchView.queryHint = "search user"
        searchView.requestFocusFromTouch()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    mainViewModel.getSearch(this@MainActivity,query.toString())
                    mainViewModel.searchData.observe(this@MainActivity, Observer {

                        listAdapter.setData(it)
                        progressBar.visibility = View.GONE
                    })
                    tvWallpaper.visibility = View.INVISIBLE
                    imgWallpaper.visibility = View.INVISIBLE
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                else{
                    return false
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
}





