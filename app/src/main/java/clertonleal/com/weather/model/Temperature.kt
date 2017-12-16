package clertonleal.com.weather.model

import com.google.gson.annotations.SerializedName

data class Temperature(@SerializedName("max") val max: Int,
                       @SerializedName("min") val min: Int,
                       @SerializedName("unit") val unit: String)