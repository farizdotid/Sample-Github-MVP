package io.mvpstarter.sample.data.model

import com.google.gson.annotations.SerializedName

data class Owner(
	@field:SerializedName("login")
	val login: String

)