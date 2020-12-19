package com.alie.submission.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alie.submission.R
import com.alie.submission.adapter.PagerAdapter
import com.alie.submission.model.User
import com.alie.submission.viewmodel.DetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    companion object{
        const val DATA_USER = "detailUser"
    }
    private lateinit var detailViewModel : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)
        setupViewPager()
        getDataUser()

        imgSettingDetail.setOnClickListener {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        imgBack.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
   private fun setupViewPager(){

       viewPager.adapter = PagerAdapter(this)
       TabLayoutMediator(tabLayout,viewPager,
       TabLayoutMediator.TabConfigurationStrategy{tab, position ->
           when (position){
               0 -> tab.text = "Followers"
               1 -> tab.text = "Following"
           }

       }).attach()
    }

    private fun getDataUser(){

        val getDataUser = intent.getParcelableExtra<User>(DATA_USER)
        progressBarDetail.visibility = View.VISIBLE
            if (getDataUser != null) {
                detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)
                detailViewModel.getUser(this,getDataUser.name)

                detailViewModel.userDetail.observe(this, Observer {
                Glide.with(this)
                    .load(getDataUser.avatarUrl)
                    .apply(RequestOptions().override(100,100))
                    .into(detailImageView)

                    detailUsername.text = it.username
                    if (it.company.isNullOrEmpty()){
                        detailCompany.visibility = View.GONE
                    }else{
                        detailCompany.text = it.company
                        detailCompany.visibility = View.VISIBLE
                    }
                    if (it.location.isNullOrEmpty()){
                        detailLocation.visibility = View.GONE
                    }else{
                        detailLocation.text = it.location
                        detailLocation.visibility = View.VISIBLE
                    }
                    if (it.followers.toString().isEmpty()){
                        detailFollowers.visibility = View.GONE
                    }else{
                        detailFollowers.text = it.followers.toString()
                        detailFollowers.visibility = View.VISIBLE
                    }
                    if (it.following.toString().isEmpty()){
                        detailFollowing.visibility = View.GONE
                    }else{
                        detailFollowing.text = it.following.toString()
                        detailFollowing.visibility = View.VISIBLE
                    }
                    if (it.repo.toString().isEmpty()){
                        detailRepos.visibility = View.GONE
                    }else{
                        detailRepos.text = it.repo.toString()
                        detailRepos.visibility = View.VISIBLE
                    }
                    detailImageView.visibility = View.VISIBLE
                    detailUsername.visibility = View.VISIBLE
                    detailFollowers.visibility = View.VISIBLE
                    detailFollowing.visibility = View.VISIBLE
                    detailRepos.visibility = View.VISIBLE
                    detailCompany.visibility = View.VISIBLE
                    detailLocation.visibility = View.VISIBLE
                    progressBarDetail.visibility = View.INVISIBLE
            })
        }
    }
}