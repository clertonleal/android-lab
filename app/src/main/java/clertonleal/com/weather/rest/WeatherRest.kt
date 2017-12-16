package clertonleal.com.weather.rest

import clertonleal.com.weather.model.Weather
import io.reactivex.Single
import retrofit2.http.GET


interface WeatherRest {

    @GET("weather/")
    fun getWeather() : Single<List<Weather>>

}