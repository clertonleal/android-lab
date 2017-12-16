package clertonleal.com.weather.viewModel

import clertonleal.com.weather.model.Weather

class WeatherViewModel(val weather: Weather, val selected: Boolean, private val click: (city: Weather) -> Unit) {

    fun weatherSelect() {
        click(weather)
    }

}