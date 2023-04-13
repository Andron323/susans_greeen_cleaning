package com.procreations.susansgreeencleaning.model

import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

data class AboutUs(
    @SerializedName("imageURL") var imageURL: String? = null,
    @SerializedName("imageRes") var imageRes: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("subTitle") var subTitle: String? = null,
    @SerializedName("content") var content: String? = null
)


