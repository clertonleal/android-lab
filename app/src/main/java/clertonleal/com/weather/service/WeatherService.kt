package clertonleal.com.weather.service

import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.rest.WeatherRest
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class WeatherService(private val weatherRest: WeatherRest) {

    fun getWeather() : Single<List<Weather>> {
        return weatherRest.getWeather().observeOn(AndroidSchedulers.mainThread())
    }

}