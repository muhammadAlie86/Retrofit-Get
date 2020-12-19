package com.alie.submission.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alie.submission.model.User
import com.alie.submission.repository.FollowingRepository

class FollowingViewModel : ViewModel(){

    private val repository = FollowingRepository()
    val listFollowing : LiveData<List<User>>

    init {
        this.listFollowing = repository.listFollowing
    }

    fun getFollowing(context: Context, username : String, part: String){
        repository.getFollowing(context,username,part)
    }
}