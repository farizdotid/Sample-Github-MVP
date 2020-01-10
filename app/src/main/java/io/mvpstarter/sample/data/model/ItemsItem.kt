package io.mvpstarter.sample.data.model

import com.google.gson.annotations.SerializedName

data class ItemsItem(

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("owner")
        val owner: Owner,

        @field:SerializedName("html_url")
        val html_url: String
)