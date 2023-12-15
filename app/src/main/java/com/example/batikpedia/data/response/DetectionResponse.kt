package com.example.batikpedia.data.response

import com.google.gson.annotations.SerializedName

data class DetectionResponse(

	@field:SerializedName("confidence")
	val confidence: Any,

	@field:SerializedName("prediction")
	val prediction: String
)
