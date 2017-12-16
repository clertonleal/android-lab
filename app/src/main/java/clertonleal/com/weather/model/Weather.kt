package clertonleal.com.weather.model

import com.google.gson.annotations.SerializedName

data class Weather(@SerializedName("id") val id: String,
                   @SerializedName("name") val name: String)