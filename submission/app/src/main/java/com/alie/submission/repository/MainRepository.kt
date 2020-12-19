package com.alie.submission.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.alie.submission.api.RetrofitInstance
import com.alie.submission.model.ResponseUser
import com.alie.submission.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository  {

    val searchData : MutableLiveData<List<User>> = MutableLiveData()

    fun getSearch(context: Context,query : String) {

        val service = RetrofitInstance.apiClient.getSearch(query)

        service.enqueue(object : Callback<ResponseUser> {
            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(context,"something wrong",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.body() != null) {
                    searchData.postValue(response.body()?.items)
                }
            }
        })
    }
}

