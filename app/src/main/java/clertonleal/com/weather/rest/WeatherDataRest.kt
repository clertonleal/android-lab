package clertonleal.com.weather.rest

import clertonleal.com.weather.model.WeatherData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface WeatherDataRest {

    @GET("cities/{cityId}/year/{year}")
    fun getWeatherData(@Path("cityId") cityId: String, @Path("year") year: Int) : Single<List<WeatherData>>

}