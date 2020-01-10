package io.mvpstarter.sample.data.model

import com.google.gson.annotations.SerializedName

data class ResponseUsers(

	@field:SerializedName("login")
	val login: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("avatar_url")
	val avatar_url: String,

	@field:SerializedName("id")
	val id: Int


)