package com.alie.submission.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailUser(
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("company")
    val company: String?= null,
    @SerializedName("followers")
    val followers: Int? = null,
    @SerializedName("following")
    val following: Int? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("login")
    val username: String? = null,
    @SerializedName("public_repos")
    val repo: Int? = null

) : Parcelable
