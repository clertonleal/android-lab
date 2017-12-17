package clertonleal.com.weather.service

import clertonleal.com.weather.model.WeatherData
import clertonleal.com.weather.rest.WeatherDataRest
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class WeatherDataService(private val weatherDataRest: WeatherDataRest) {

    fun getWeatherData(cityId: String, year: Int) : Single<List<WeatherData>> {
        return weatherDataRest.getWeatherData(cityId, year).observeOn(AndroidSchedulers.mainThread())
    }

}