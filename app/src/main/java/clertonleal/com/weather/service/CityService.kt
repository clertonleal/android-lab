package clertonleal.com.weather.service

import clertonleal.com.weather.model.City
import clertonleal.com.weather.rest.CityRest
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers


class CityService(private val cityRest: CityRest) {

    fun getCities() : Single<List<City>> {
        return cityRest.getCities().observeOn(AndroidSchedulers.mainThread())
    }

}