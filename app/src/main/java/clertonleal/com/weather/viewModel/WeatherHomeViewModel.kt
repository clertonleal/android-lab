package clertonleal.com.weather.viewModel

import clertonleal.com.weather.model.Weather

class WeatherHomeViewModel(val weather: Weather, private val click: () -> Unit) {

    fun clickWeather() {
        click()
    }

}