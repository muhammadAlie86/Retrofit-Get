package com.alie.submission.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseUser(

    @SerializedName("total_count")
    val totalCount :Int,

    @SerializedName("incomplete_results")
    val incompleteResults :Boolean,

    @SerializedName("items")
    val items : List<User>
) : Parcelable