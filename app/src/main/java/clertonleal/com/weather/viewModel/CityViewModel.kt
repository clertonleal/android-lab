package clertonleal.com.weather.viewModel

import clertonleal.com.weather.model.City


class CityViewModel(val city: City, private val click: (city: City) -> Unit) {

    fun citySelect() {
        click(city)
    }

}