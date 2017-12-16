package clertonleal.com.weather.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class WeatherData(@SerializedName("date") val date: Date,
                       @SerializedName("temperature") val temperature: Temperature,
                       @SerializedName("weather") val weather: String,
                       @SerializedName("woeid") val cityId: String)