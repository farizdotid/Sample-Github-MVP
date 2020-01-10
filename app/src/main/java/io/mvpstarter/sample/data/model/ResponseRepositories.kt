package io.mvpstarter.sample.data.model

import com.google.gson.annotations.SerializedName

data class ResponseRepositories(
	@field:SerializedName("items")
	val items: List<ItemsItem>
)