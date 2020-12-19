package com.alie.submission.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    @SerializedName("login")
    val name: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("id")
    val id: Int

) : Parcelable
