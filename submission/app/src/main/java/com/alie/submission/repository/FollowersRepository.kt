package com.alie.submission.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.alie.submission.api.RetrofitInstance
import com.alie.submission.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersRepository {

    val listFollower : MutableLiveData<List<User>> = MutableLiveData()

    fun getFollower(context :Context,username: String,part : String) {

        val service = RetrofitInstance.apiClient.getFollower(username,part)

        service.enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                Toast.makeText(context,"something wrong",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    listFollower.value = response.body()
                }
            }

        })

    }
}