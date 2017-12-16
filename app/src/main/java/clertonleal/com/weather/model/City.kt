package clertonleal.com.weather.model

import com.google.gson.annotations.SerializedName

data class City(@SerializedName("woeid") val id: String,
                @SerializedName("district") val district: String,
                @SerializedName("province") val province: String,
                @SerializedName("state_acronym") val stateAcronym: String,
                @SerializedName("country") val country: String)