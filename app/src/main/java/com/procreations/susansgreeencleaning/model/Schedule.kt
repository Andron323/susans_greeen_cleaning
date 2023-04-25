package com.procreations.susansgreeencleaning.model

import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

data class Schedule(
    @SerializedName("imageURL") var imageURL: String? = null,
    @SerializedName("imageRes") var imageRes: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("subTitle") var subTitle: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("repeat") var repeat: String? = null,
    @SerializedName("content") var content: String? = null
)


