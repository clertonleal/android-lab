package clertonleal.com.weather.rest

import clertonleal.com.weather.model.City
import io.reactivex.Single
import retrofit2.http.GET


interface CityRest {

    @GET("cities/")
    fun getCities() : Single<List<City>>

}