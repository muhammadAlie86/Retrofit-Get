package com.alie.submission.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.alie.submission.api.RetrofitInstance
import com.alie.submission.model.DetailUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRepository {

    val userDetail : MutableLiveData<DetailUser> = MutableLiveData()

    fun getUser(context : Context,username : String){

        val serviceUser = RetrofitInstance.apiClient.getUser(username)

        serviceUser.enqueue(object : Callback<DetailUser>{
            override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                Toast.makeText(context,"something wrong", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DetailUser>, response: Response<DetailUser>) {
                if (response.isSuccessful){
                    userDetail.value = response.body()
                }
            }

        })
    }
}