package clertonleal.com.weather.view.`interface`

import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather


interface HomeView {

    fun openSelectCities(cities: List<City>)
    fun openSelectWeather(weather: List<Weather>, selectedWeather: List<Weather>)
    fun openResult(weather: ArrayList<Weather>, days: Int, city: City)

}