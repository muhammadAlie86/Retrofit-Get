package com.alie.submission.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alie.submission.model.DetailUser
import com.alie.submission.repository.DetailRepository

class DetailViewModel : ViewModel(){

    private val detailRepository = DetailRepository()
    val userDetail : LiveData<DetailUser>

    init {
        this.userDetail = detailRepository.userDetail
    }

    fun getUser(context: Context,username : String){
        detailRepository.getUser(context,username)
    }
}